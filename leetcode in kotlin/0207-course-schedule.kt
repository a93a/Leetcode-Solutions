class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val edges = Array<ArrayList<Int>> (numCourses) { ArrayList() }
        val visit = HashSet<Int>()

        prerequisites.forEach {
            val (a,b) = it
            edges[a].add(b)
        }

        fun dfs(i: Int): Boolean {
            if (i in visit) return false
            if (edges[i].size == 0) return true

            visit.add(i)
            edges[i].forEach {
                if (!dfs(it)) return false
            }

            visit.remove(i)
            edges[i].clear()
            return true
        }

        for (i in 0..edges.size-1) {
            if (!dfs(i)) return false
        } 

        return true
    }
}
