class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val degrees = IntArray (n + 1)

        for ((o, i) in trust) {
           degrees[i]++
           degrees[o]--
        }

        for (i in 1..n) {
            if (degrees[i] == n - 1)
                return i
        }

        return -1
    }
}
