class Solution {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val stickCount = HashMap<String, MutableMap<Char, Int>>().apply {
            stickers.forEach { s ->
                this[s] = s.groupingBy { it }
                    .eachCount()
                    .toMutableMap()
            }
        }

        val dp = HashMap<String, Int>()

        fun dfs(t: String, stick: MutableMap<Char, Int>): Int {
            dp[t]?.let {
                return it
            }

            var res = if (stick.isEmpty()) 0 else 1
            val remainT = StringBuilder()
            for (c in t) {
                if (c in stick && stick[c]!! > 0) {
                    stick[c] = stick[c]!! - 1
                } else {
                    remainT.append(c)
                }
            }

            if (remainT.length > 0) {
                val remainTS = remainT.toString()
                var used = Integer.MAX_VALUE
                for (s in stickCount.values) {
                    if (remainTS[0]!! !in s)
                        continue
                    used = minOf(used, dfs(remainTS, s.toMutableMap()))
                }

                dp[remainTS] = used
                res = if (used == Integer.MAX_VALUE ) Integer.MAX_VALUE else res + used
            }

            return res
        }


        val res = dfs(target, mutableMapOf<Char, Int>())
        return if (res == Integer.MAX_VALUE) -1 else res
    }
}

// Alternative solution
class Solution {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val n = target.length
        val m = 1 shl n
        val dp = IntArray (m) { Integer.MAX_VALUE }

        dp[0] = 0
        for (i in 0 until m) {
            if (dp[i] == Integer.MAX_VALUE)
                continue

            for (s in stickers) {
                var subset = i
                for (c in s) {
                    for (r in 0 until n) {
                        if (target[r] == c && ((subset shr r) and 1) == 0) {
                            subset = subset or (1 shl r)
                            break
                        }
                    }
                }

                dp[subset] = minOf(dp[subset], dp[i] + 1)
            }
        }

        return if (dp[m - 1] == Integer.MAX_VALUE) -1 else dp[m - 1]
    }
}
