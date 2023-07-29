class Solution {
    fun soupServings(n: Int): Double {
        if (n > 4800) return 1.0

        val cache = Array (n + 1) { DoubleArray (n + 1) { -1.0 } }

        fun serve(a: Int, b: Int): Double {
            if (a <= 0 && b <= 0) return 0.5
            if (a <= 0) return 1.0
            if (b <= 0) return 0.0

            if (cache[a][b] != -1.0) return cache[a][b]

            cache[a][b] = 0.25 * (
                serve(a - 100, b) +
                serve(a - 75, b - 25) +
                serve(a - 50, b - 50) +
                serve(a - 25, b - 75)
            )

            return cache[a][b]
        }

        return serve(n, n)
    }
}
