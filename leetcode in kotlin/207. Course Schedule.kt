class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val edges = Array<ArrayList<Int>>(numCourses) { ArrayList() }
        val visited = BooleanArray(numCourses)
        prerequisites.forEach{
            val (a,b) = it
            edges[a].add(b)
        }
        for(i in 0..edges.size-1){
            if(dfs(i, visited, edges) == false)
                return false
        } 
        return true
    }
    private fun dfs(course: Int, visited: BooleanArray, edges: Array<ArrayList<Int>>): Boolean{
        if(visited[course]==true)   //cycle detection from Course A to B and B to A
            return false
        if(edges[course].size == 0)
            return true
        visited[course] = true
        edges[course].forEach{
            if(dfs(it, visited, edges) == false)
                return false
        }
        visited[course] = false
        edges[course].clear()
        return true
    }
}
