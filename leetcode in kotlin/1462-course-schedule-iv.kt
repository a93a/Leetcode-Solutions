class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adj = mutableMapOf<Int, MutableList<Int>>().apply {
            prerequisites.forEach { (prereq, course) ->
                this.getOrPut(course) { mutableListOf() }.add(prereq)
            }
        }

        val preReqMap = mutableMapOf<Int, HashSet<Int>>()

        fun dfs(course: Int): HashSet<Int> {
            if (course !in preReqMap) {
                preReqMap[course] = HashSet<Int>().apply { add(course) }
                adj[course]?.forEach { prereq ->
                    preReqMap[course] = (preReqMap[course] ?: hashSetOf()) unionWith dfs(prereq)
                }
            }
            return preReqMap[course] ?: hashSetOf()
        }

        (0 until numCourses).forEach { dfs(it) }

        var res = mutableListOf<Boolean>().apply {
            queries.forEach { (prereq, course) ->
                this.add(preReqMap[course]?.let { prereq in it } ?: false)
            }
        }
        
        return res
    }

    infix fun HashSet<Int>.unionWith(another: HashSet<Int>): HashSet<Int> {
        another.forEach {
            this@unionWith.add(it)
        }
        return this
    }
}
