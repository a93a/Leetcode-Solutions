class Solution {
    fun strangePrinter(s: String): Int {

        val short = StringBuilder()
        for (c in s) {
            if (short.length > 0 && short[short.lastIndex] == c) continue
            short.append(c)
        }
        
        val cache = Array (short.length) { IntArray(short.length) { -1 } }

        fun dfs(l: Int, r: Int): Int {
            if (l == r) return 1
            if (l > r) return 0
            if (cache[l][r] != -1) return cache[l][r]

            var cost = 1 + dfs(l, r - 1)
            for (i in l until r) {
                if (short[i] == short[r])
                    cost = minOf(cost, dfs(l, i) + dfs(i + 1, r - 1))
            }

            cache[l][r] = cost
            return cost
        }

        return dfs(0, short.lastIndex)
    }
}
