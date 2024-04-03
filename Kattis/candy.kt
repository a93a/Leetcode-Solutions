fun main(args: Array<String>) {
    val line = readLine()!!.split(' ')
    val n = line[0].toInt()
    val f = line[1].toInt()
    val t = line[2].toLong()
    val candies = readLine()!!.split(' ').map { it.toInt() }

    val maxSwaps = (n + 1) * (n + 1)

    fun dfs(i: Int, boxes: Int, swaps: Int, dp: Array<Array<LongArray>>): Long {
        if (boxes == f) return 0L
        if (i == n) return Long.MIN_VALUE
        if (dp[i][boxes][swaps] != -1L) return dp[i][boxes][swaps]

        var res = Long.MIN_VALUE

        res = maxOf(res, dfs(i + 1, boxes, swaps, dp))
        if (swaps - (i - boxes) >= 0) {
            val take = dfs(i + 1, boxes + 1, swaps - (i - boxes), dp)
            if (take != Long.MIN_VALUE)
                res = maxOf(res, candies[i] + take)
        }

        dp[i][boxes][swaps] = res
        return dp[i][boxes][swaps]
    }

    var res = -1
    val dp = Array (n + 1) { Array (f + 1) { LongArray (maxSwaps) { -1L } } }
    for (ms in 0 until n * n) {
        val sum = dfs(0,0,ms, dp)
        if (sum >= t) {
            res = ms
            break
        }
    }

    println(if (res == -1) "NO" else res)
}
