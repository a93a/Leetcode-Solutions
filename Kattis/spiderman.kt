fun main(args: Array<String>) {

    val n = readLine()!!.toInt()
    repeat (n) {
        val m = readLine()!!.toInt()
        val dist = readLine()!!.split(' ').map { it.toInt() }
        val dp = Array (m + 1) { IntArray (1001) { -1 } }
        val dir = Array (m + 1) { IntArray (1001) }

        dp[m][0] = 0 // base case
        for (i in (m - 1) downTo 0) {
            for (h in 0..1000) {
                var res = -1

                // Can we go up?
                if (h + dist[i] < 1001 && dp[i + 1][h + dist[i]] != -1) {
                    res = maxOf(h, dp[i + 1][h + dist[i]])
                    dir[i][h] = 1
                }

                // Can we go down?
                if (h - dist[i] >= 0 && dp[i + 1][h - dist[i]] != -1) {
                    if (res == -1 || res > dp[i + 1][h - dist[i]]) {
                        res = maxOf(h, dp[i + 1][h - dist[i]])
                        dir[i][h] = -1
                    }
                }

                dp[i][h] = res
            }
        }

        // Build & output path
        if (dp[0][0] == -1) {
            println("IMPOSSIBLE")
        } else {
            var cur = 0
            var res = ""
            for (i in 0 until m) {
                res += if (dir[i][cur] == 1) "U" else "D"
                cur += dir[i][cur] * dist[i]
            }
            println(res)
        }
    }
}
