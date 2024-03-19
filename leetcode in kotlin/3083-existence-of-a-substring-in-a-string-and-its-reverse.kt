// DIY logic
class Solution {
    fun isSubstringPresent(s: String): Boolean {
        val set = HashSet<String> ()
        for (i in 2..s.length) {
            set.add(s.substring(i - 2, i))
        }

        for (i in s.lastIndex downTo 1) {
            if ("${s[i]}${s[i - 1]}" in set)
                return true
        }

        return false
    }
} 

// Use kotlin functions
class Solution {
    fun isSubstringPresent(s: String): Boolean {
        val set = HashSet<String> ()
        s.windowed(2).forEach { set.add(it) }

        return s.reversed().windowed(2).any { it in set }
    }
} 
