// DIY logic
class Solution {
    fun lengthOfLastWord(s: String): Int {
        var p = s.length-1
        while(s[p].isWhitespace()) p--
        var count = 0
        while(p >= 0 && !s[p].isWhitespace()){
            count++
            p--
        }
        return count
    }
}

// Kotlin functions
class Solution {
    fun lengthOfLastWord(s: String) = s
        .reversed()
        .asIterable()
        .dropWhile { it == ' ' }
        .takeWhile { it != ' ' }
        .count()
}
