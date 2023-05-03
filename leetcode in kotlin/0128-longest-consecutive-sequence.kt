/*
* solution 1
*/
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hm = HashMap<Int, Int>()

        var res = 0
        for (n in nums) {
            if (n !in hm) {
               val lower = hm[n - 1]?: 0
               val higher = hm[n + 1]?: 0
               val len = higher + lower + 1

               hm[n] = len
               hm[n - lower] = len
               hm[n + higher] = len

               res = maxOf(res, len)
            }
        }

        return res
    }
}

/*
* solution 2
*/
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()

        var res = 0
        for (n in nums) {
            if (n - 1 !in numSet) {
                var len = 0
                while (n + len in numSet) len++
                res = maxOf(res, len)
            }
        }

        return res
    }
}
