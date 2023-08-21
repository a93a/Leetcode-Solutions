class Solution {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        val groups = HashMap<Int, MutableList<Int>>()
        val itemBefore = HashMap<Int, HashSet<Int>>()
        val itemAfter = HashMap<Int, HashSet<Int>>()
        val groupBefore = HashMap<Int, HashSet<Int>>()
        val groupAfter = HashMap<Int, HashSet<Int>>()
        
        var new = m
        for (i in group.indices) {
            group[i] = if (group[i] == -1) new++ else group[i]
        }

        for (i in beforeItems.indices) {
            if (beforeItems[i].isEmpty()) continue

            val set = HashSet<Int>()
            for (item in beforeItems[i]) {
                if (group[item] != group[i]) set.add(group[item])
                if (!itemAfter.contains(i)) itemAfter[i] = HashSet<Int>()
                if (!itemBefore.contains(item)) itemBefore[item] = HashSet<Int>()
                itemAfter[i]!!.add(item)
                itemBefore[item]!!.add(i)
            }

            if (set.isNotEmpty()) groupAfter[group[i]] = set
        }

        for (g in groupAfter.keys) {
            for (h in groupAfter[g]!!) {
                if (!groupBefore.contains(h)) groupBefore[h] = HashSet<Int>()
                groupBefore[h]!!.add(g)
            }
        }

        val itemQ = LinkedList<Int>()
        for (v in 0 until n) {
            if (!itemAfter.contains(v)) itemQ.addLast(v)
        }

        while (itemQ.isNotEmpty()) {
            val nextItem = itemQ.removeFirst()
            if (!groups.contains(group[nextItem])) groups[group[nextItem]] = mutableListOf<Int>()
            groups[group[nextItem]]!!.add(nextItem)
            if (itemBefore.contains(nextItem)) {
                for (v in itemBefore[nextItem]!!) {
                    itemAfter[v]!!.remove(nextItem)
                    if (itemAfter[v]!!.isEmpty()) {
                        itemAfter.remove(v)
                        itemQ.addLast(v)
                    }
                }
                itemBefore.remove(nextItem)
            }
        }

        if (itemBefore.isNotEmpty() || itemAfter.isNotEmpty()) return intArrayOf()     

        val groupQ = LinkedList<Int>()
        for (g in groups.keys) {
            if (!groupAfter.contains(g)) groupQ.addLast(g)
        }

        val res = mutableListOf<Int>()
        while (groupQ.isNotEmpty()) {
            val nextGroup = groupQ.removeFirst()
            res.addAll(groups[nextGroup]!!)
            if (groupBefore.contains(nextGroup)) {
                for (g in groupBefore[nextGroup]!!) {
                    groupAfter[g]!!.remove(nextGroup)
                    if (groupAfter[g]!!.isEmpty()) {
                        groupAfter.remove(g)
                        groupQ.addLast(g)
                    }
                }
                groupBefore.remove(nextGroup)
            }
        }
        
        return if ((groupBefore.isNotEmpty() || groupAfter.isNotEmpty())) intArrayOf() else res.toIntArray()
    }
}
