// brute force accepted O(n^3)
class Solution {
    fun distributeCandies(n: Int, limit: Int): Int {
        var res = 0
        for (i in 0..limit) {
            for (j in 0..limit) {
                for (k in 0..limit) {
                    if (i + j + k == n)
                        res++
                }
            }
        }
        return res
    }
}

// Use the solution from 2929. Distribute Candies Among Children II with the tougher constraints
// O(n)
class Solution {
    fun distributeCandies(n: Int, limit: Int): Int {
        var res = 0
        for (firstTake in 0..minOf(n, limit)) {
            val secondMax = minOf(limit, n - firstTake)
            val secondMin = maxOf(0, n - firstTake - limit)
            res += maxOf(secondMax - secondMin + 1, 0)
        }
        return res
    }
}
