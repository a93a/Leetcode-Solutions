class Solution {
    fun maximumLength(nums: IntArray): Int {
        val nums = nums.map { it.toDouble() }
        val count = HashMap<Double, Int>()

        for (n in nums)
            count[n] = (count[n] ?: 0) + 1
        
        var res = 1
        for (n in nums) {
            if (n == 1.0) {
                if ((count[n] ?: 0) % 2 == 0)
                    count[n] = (count[n] ?: 0) - 1
                res = maxOf(res, (count[n] ?: 0))
                continue
            }

            var cur = 1
            var next = sqrt(n)
            while ((count[next] ?: 0) >= 2) {
                cur += 2
                next = sqrt(next)
            }
            
            res = maxOf(res, cur)
        }

        return res
    }
}
