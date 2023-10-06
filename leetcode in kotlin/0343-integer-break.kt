/*
* DP solution 0(n^2)
*/
class Solution {
    fun integerBreak(n: Int): Int {
        val cache = IntArray(n + 1) {-1}

        cache[1] = 1
        for (num in 2..n) {
            cache[num] = if (num == n) 0 else num
            for (i in 1..num) {
                val res = cache[i] * cache[num - i]
                cache[num] = maxOf(cache[num], res)
            }
        }
        
        return cache[n]
    }
}

/*
* DFS + memoization solution 0(n^2)
*/
class Solution {
    fun integerBreak(n: Int): Int {
        val cache = IntArray(n + 1) {-1}

        fun dfs(num: Int): Int {
            if (cache[num] != -1) return cache[num]

            cache[num] = if (num == n) 0 else num
            for (i in 1 until num) {
                val res = dfs(i) * dfs(num - i)
                cache[num] = maxOf(cache[num], res)
            }

            return cache[num]
        }

        return dfs(n)
    }
}

// Mathimatically solved O(n)
class Solution {
    fun integerBreak(n: Int): Int {
        if (n < 4) return n - 1

        var res = 1
        var n2 = n
        while (n2 > 4) {
            res *= 3
            n2 -=3
        }

        res *= n2
        return res
    }
}
