class Solution {
    fun makeGood(s: String) = buildString {
        for (c in s) {
            if (isNotEmpty() && Math.abs(get(lastIndex) - c) == 32) deleteAt(lastIndex)
            else append(c)
        }
        return toString()
    }
}
