class Solution {
    fun minOperations(nums: IntArray): Int {
        val counts = HashMap<Int, Int>().apply {
            nums.forEach {
                this[it] = getOrDefault(it, 0) + 1
            }
        }

        if ((counts.values.min() ?: 0) == 1) return -1

        var res = 0
        counts.values.forEach {
            res += (it / 3)
            if ((it % 3) > 0) res ++
        }

        return res
    }
}
