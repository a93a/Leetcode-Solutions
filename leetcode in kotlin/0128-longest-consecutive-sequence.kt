/*
* Union Find solution
*/
lass Solution {

    class DSU(val n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }

        fun find(x: Int): Int {
            if (parent[x] != x)
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            if(px != py) {
                parent[py] = px
                size[px] += size[py]
            }
        }

        fun getLongest(): Int {
            var res = 0
            for (i in parent.indices) {
                if (parent[i] == i)
                    res = maxOf(res, size[i])
            }
            return res
        }
    }
    

    fun longestConsecutive(nums: IntArray): Int {
        val hm = HashMap<Int, Int>()
        val dsu = DSU(nums.size)

        for ((i,n) in nums.withIndex()) {
            if (n in hm) continue

            hm[n - 1]?.let { dsu.union(i, hm[n - 1]!!) }
            hm[n + 1]?.let { dsu.union(i, hm[n + 1]!!) }

            hm[n] = i
        }

        return dsu.getLongest()
    }
}

/*
* solution 1
*/
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hm = HashMap<Int, Int>()

        var res = 0
        for (n in nums) {
            if (n !in hm) {
               val lower = hm[n - 1]?: 0
               val higher = hm[n + 1]?: 0
               val len = higher + lower + 1

               hm[n] = len
               hm[n - lower] = len
               hm[n + higher] = len

               res = maxOf(res, len)
            }
        }

        return res
    }
}

/*
* solution 2
*/
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()

        var res = 0
        for (n in nums) {
            if (n - 1 !in numSet) {
                var len = 0
                while (n + len in numSet) len++
                res = maxOf(res, len)
            }
        }

        return res
    }
}
