// Iterative
fun main(args: Array<String>) {

    val n = readLine()!!.toInt()
    repeat (n) {
        val m = readLine()!!.toInt()
        val dist = readLine()!!.split(' ').map { it.toInt() }
        val dp = Array (m + 1) { IntArray (1001) { -1 } }
        val dir = Array (m + 1) { IntArray (1001) }

        dp[m][0] = 0
        for (i in (m - 1) downTo 0) {
            for (h in 0..1000) {
                var res = -1

                if (h + dist[i] < 1001 && dp[i + 1][h + dist[i]] != -1) {
                    res = maxOf(h, dp[i + 1][h + dist[i]])
                    dir[i][h] = 1
                }

                if (h - dist[i] >= 0 && dp[i + 1][h - dist[i]] != -1) {
                    if (res == -1 || res > dp[i + 1][h - dist[i]]) {
                        res = maxOf(h, dp[i + 1][h - dist[i]])
                        dir[i][h] = -1
                    }
                }

                dp[i][h] = res
            }
        }

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

// recursive + memoization
fun main(args: Array<String>) {

    val n = readLine()!!.toInt()
    repeat (n) {
        val m = readLine()!!.toInt()
        val dist = readLine()!!.split(' ').map { it.toInt() }
        val dp = Array (m + 1) { IntArray (1001) { -1 } }
        val dir = Array (m + 1) { IntArray (1001) }

        fun dfs(i: Int, h: Int): Int {
            if (i == m) return if (h == 0) 0 else Int.MIN_VALUE
            if (dp[i][h] != -1) return dp[i][h]

            var res = Int.MIN_VALUE

            if (h + dist[i] < 1001) {
                val up = dfs(i + 1, h + dist[i])
                if (up != Int.MIN_VALUE) {
                    res = maxOf(h, up)
                    dir[i][h] = 1
                }
            }

            if (h - dist[i] >= 0) {
                val down = dfs(i + 1, h - dist[i])
                if (down != Int.MIN_VALUE && (res == Int.MIN_VALUE || res > down)) {
                    res = maxOf(h, down)
                    dir[i][h] = -1
                }
            }

            dp[i][h] = res
            return res
        }

        val res = dfs(0, 0)

        if (res == Int.MIN_VALUE) {
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
