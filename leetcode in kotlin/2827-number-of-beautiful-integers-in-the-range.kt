class Solution {
    fun numberOfBeautifulIntegers(low: Int, high: Int, k: Int): Int {
        val dp = HashMap<String, Long>()

        fun dfs(s: String, n: Int, tight: Boolean, leading: Boolean, even: Int, odd: Int, r: Int): Long {
            if (n == 0) return if (even == odd && r == 0) 1 else 0
            dp["$n:$tight:$leading:$even:$odd:$r"]?.let { return it }

            val limit = if (tight) s[s.length - n] - '0' else 9
            var res = 0L
            for (i in 0..limit) {
                if (leading  && i == 0) {
                    res += dfs(s, n - 1, false, leading && i == 0, 0, 0, 0)
                } else {
                    if (i % 2 == 0) 
                        res += dfs(s, n - 1, tight && (i == limit), false, even + 1, odd, (r * 10 + i) % k)
                    else 
                        res += dfs(s, n - 1, tight && (i == limit), false, even, odd + 1, (r * 10 + i) % k)
                }
            }

            dp["$n:$tight:$leading:$even:$odd:$r"] = res
            return res
        }

        val sLow = "" + (low - 1)
        val resLow = dfs(sLow, sLow.length, true, true, 0, 0, 0)
        
        dp.clear()

        val sHigh = "" + high
        val resRight = dfs(sHigh, sHigh.length, true, true, 0, 0, 0)

        return (resRight - resLow).toInt()
    }
}
