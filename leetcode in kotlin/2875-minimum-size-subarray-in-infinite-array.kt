class Solution {
    fun minSizeSubarray(nums: IntArray, _target: Int): Int {
        val n = nums.size
        val numSum = (nums.sum() ?: 1)
        var k = _target / numSum
        val target = _target % numSum

        if (target == 0) return k * n

        var res = Integer.MAX_VALUE
        var sum = 0
        var j = 0
        for (i in 0 until (2 * n)) {
            sum += nums[i % n]

            while (sum > target) {
                sum -= nums[j % n]
                j++
            } 

            if (sum == target)
                res = minOf(res, i - j + 1)
        }

        return if (res < Integer.MAX_VALUE) res + k * n else -1
    }
}
