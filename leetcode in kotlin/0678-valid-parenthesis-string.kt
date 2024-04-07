// DP
class Solution {
    fun checkValidString(s: String): Boolean {
        val n = s.length
        val dp = Array (n + 1) { IntArray (n + 1) { -1 } }

        fun dfs(i: Int, d: Int): Int {
            if (i == n) return if (d == 0) 1 else 0
            if (dp[i][d] != -1) return dp[i][d]

            dp[i][d] = 0
            
            if (s[i] == '(') {
                dp[i][d] = dfs(i + 1, d + 1)
            } else if (s[i] == ')') {
                dp[i][d] = if (d > 0) dfs(i + 1, d - 1) else 0
            } else {
                dp[i][d] = maxOf(
                    dfs(i + 1, d + 1), 
                    if (d > 0) dfs(i + 1, d - 1) else 0, 
                    dfs(i + 1, d)
                )
            }

            return dp[i][d]
        }

        return if (dfs(0, 0) == 1) true else false
    }
}

// Greedy with stacks
class Solution {
    fun checkValidString(s: String): Boolean {
        val op = LinkedList<Int>()
        val st = LinkedList<Int>()

        for ((i, c) in s.withIndex()) {
            if (c == '(') op.addLast(i)
            else if (c == '*') st.addLast(i)
            else {
                if (op.isEmpty() && st.isEmpty()) return false
                if (op.isNotEmpty()) op.removeLast()
                else st.removeLast()
            }
        }

        while (op.isNotEmpty() && st.isNotEmpty()) {
            if (op.removeLast() > st.removeLast()) 
                return false
        }

        return op.isEmpty()
    }
}
