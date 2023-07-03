class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false

        if (s == goal) {
            return if (s.toSet().size < s.length) true else false
        }
        
        val diff = ArrayList<Int>().apply {
            for (i in s.indices) {
                if (s[i] != goal[i]) add(i)
            }
        }

        return if (diff.size == 2 && 
            s[diff[0]] == goal[diff[1]] && 
            s[diff[1]] == goal[diff[0]]) true else false

    }
}
