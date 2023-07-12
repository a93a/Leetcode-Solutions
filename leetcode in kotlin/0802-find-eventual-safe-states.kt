class Solution {
    fun eventualSafeNodes(g: Array<IntArray>): List<Int> {
        val isSafe = BooleanArray (g.size)
        val visit = HashSet<Int>()

        fun dfs(n: Int): Boolean{
            if (n in visit) 
                return isSafe[n]

            visit.add(n)
            g[n].forEach {
                if (dfs(it) == false)
                    return false
            }

            isSafe[n] = true
            return true
        }

        val res = ArrayList<Int>()
        for (i in 0 until g.size) {
            if (dfs(i))
                res.add(i)
        }

        return res
    }
}
