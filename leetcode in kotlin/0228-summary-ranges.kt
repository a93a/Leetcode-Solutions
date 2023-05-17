class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val res = ArrayList<String>()

        var i = 0
        while (i < nums.size) {
            var j = i
            while (j + 1 < nums.size && nums[j + 1] - nums[j] == 1)
                j++
            if (i == j) res.add("${nums[j]}") else res.add("${nums[i]}->${nums[j]}")
            i = j + 1
        }

        return res
    }
}
