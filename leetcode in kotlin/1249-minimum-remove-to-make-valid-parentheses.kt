class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val filterClose = mutableListOf<Char>()
        var op = 0
        for (c in s) {
            if (c == '(') {
                filterClose.add(c)
                op++
            } else if (c == ')' && op > 0) {
                filterClose.add(c)
                op--
            } else if (c != ')') {
                filterClose.add(c)
            }
        }

        val filterOpen = mutableListOf<Char>()
        for (i in filterClose.lastIndex downTo 0) {
            if (filterClose[i] == '(' && op > 0) op--
            else filterOpen.add(0, filterClose[i])
        }

        return filterOpen.joinToString("")
    }
}
