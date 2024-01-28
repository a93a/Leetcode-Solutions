// DIY logic
class Solution {
    fun countKeyChanges(s: String): Int {
        var res = 0
        for (i in 1..s.lastIndex) {
            if (s[i].lowercase() != s[i - 1].lowercase())
                res++
        }
        return res
    }
}

// Kotlin idiomatic
class Solution {
    fun countKeyChanges(s: String) = s.lowercase()
        .zip(s.lowercase().substring(1, s.length))
        .filter { it.first != it.second }
        .count()
}
