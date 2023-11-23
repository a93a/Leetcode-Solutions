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
