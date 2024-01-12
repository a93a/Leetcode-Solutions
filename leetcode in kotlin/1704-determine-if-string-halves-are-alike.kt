// DIY logic
class Solution {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        var res = 0
        for (i in s.indices) {
            if (s[i] in vowels) {
                res += if (i < s.length / 2) 1 else -1
            }
        }

        return res == 0
    }
}

// Power of Kotlin
class Solution {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    fun halvesAreAlike(s: String) = 
        s.substring(0, s.length / 2).count { it in vowels } ==
        s.substring(s.length / 2, s.length).count { it in vowels }
}
