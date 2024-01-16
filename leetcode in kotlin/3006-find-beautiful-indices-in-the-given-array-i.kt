// Brute force
class Solution {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        val n = s.length
        val m = a.length
        val p = b.length
        val AS = mutableListOf<Int>()
        val BS = mutableListOf<Int>()

        for (i in 0 until n) {
            if (i + m <= n && s.substring(i, i + m) == a)
                AS.add(i)
            if (i + p <= n && s.substring(i, i + p) == b)
                BS.add(i)
        }

        val res = mutableListOf<Int>()
        var j = 0
        for (i in AS.indices) {
            while (j < BS.size && AS[i] > k + BS[j])
                j++
            if (j < BS.size && Math.abs(AS[i] - BS[j]) <= k)
                res.add(AS[i])
        }

        return res
    }
}

// KMP
class Solution {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        val AS = kmp(s, a)
        val BS = kmp(s, b)

        val res = mutableListOf<Int>()
        var j = 0
        for (i in AS.indices) {
            while (j < BS.size && AS[i] > k + BS[j])
                j++
            if (j < BS.size && Math.abs(AS[i] - BS[j]) <= k)
                res.add(AS[i])
        }

        return res
    }

    private fun kmp(s: String, a: String): List<Int> {
        val match = a + "#" + s

        val lps = mutableListOf(0)
        for (i in 1..match.lastIndex) {
            var j = lps[i - 1]
            while (j > 0 && match[j] != match[i])
                j = lps[j - 1]
            if (match[j] == match[i]) lps.add(j + 1)
            else lps.add(0)
        }

        val res = mutableListOf<Int>()
        for (i in 0..lps.lastIndex) {
            if (lps[i] == a.length)
                res.add(i - 2 * a.length)
        }

        return res
    }
}
