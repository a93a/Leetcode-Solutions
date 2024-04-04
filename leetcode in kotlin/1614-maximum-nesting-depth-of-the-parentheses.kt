class Solution {
    fun maxDepth(s: String): Int {
        var stack = 0
        var res = 0
        for (c in s) {
            if (c == '(') {
                stack++
            } else if (c == ')') {
                res = maxOf(res, stack)
                stack--
            }
        }
        return res
    }
}
