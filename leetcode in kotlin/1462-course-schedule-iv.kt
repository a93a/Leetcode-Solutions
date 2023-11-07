class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adj = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in prerequisites)
                this[v] = getOrDefault(v, mutableListOf<Int>()).apply { add(u) }
        }

        val preReqMap = HashMap<Int, HashSet<Int>>()

        fun dfs(n: Int): HashSet<Int> {
            if (n !in preReqMap) {
                preReqMap[n] = HashSet<Int>()
                adj[n]?.forEach { prereq ->
                    preReqMap[n] = preReqMap[n]!! unionWith dfs(prereq)
                }
                preReqMap[n]!!.add(n)
            }
            return preReqMap[n]!!
        }

        for (n in 0 until numCourses)
            dfs(n)
            
        var res = mutableListOf<Boolean>()
        for ((u, v) in queries)
            res.add(u in preReqMap[v]!!)

        return res
    }

    infix fun HashSet<Int>.unionWith(another: HashSet<Int>): HashSet<Int> {
        another.forEach {
            this@unionWith.add(it)
        }
        return this
    }
}
