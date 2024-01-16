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

// Rabin-Karp
class Solution {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        val AS = rabinKarp(s, a)
        val BS = rabinKarp(s, b)

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

    fun rabinKarp(a: String, s: String): List<Int> {
        val d = 31
        val q = 1_000_000_009L
        val n = s.length
        val m = a.length
        val pPow = LongArray(maxOf(n, m)) { 1L }

        for (i in 1 until pPow.size)
            pPow[i] = (pPow[i - 1] * d) % q

        val h = LongArray(m + 1) { 0L }
        for (i in 0 until m)
            h[i + 1] = (h[i] + (a[i] - 'a' + 1) * pPow[i]) % q

        var hs = 0L
        for (i in 0 until n)
            hs = (hs + (s[i] - 'a' + 1) * pPow[i]) % q

        val res = mutableListOf<Int>()
        for (i in 0..(m - n)) {
            val curH = (h[i + n] + q - h[i]) % q
            if (curH == hs * pPow[i] % q)
                res.add(i)
        }

        return res
    }
}
