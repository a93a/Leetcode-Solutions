class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        var res = "abababababababababab"
        val map = getMap(licensePlate)

        for (word in words) {
            val map2 = getMap(word)

            if (equal(map, map2) && word.length < res.length)
                res = word
        }

        return res
    }

    private fun equal(a: IntArray, b: IntArray): Boolean {
        for (i in 0 until 26) {
            if (b[i] < a[i]) 
                return false
        }
        return true
    }

    private fun getMap(s: String) = IntArray (26).apply {
        for (c in s) {
            if (c in 'A'..'Z') this[c.toLowerCase() - 'a']++
            else if (c in 'a'..'z') this[c - 'a']++
        }
    }
}
