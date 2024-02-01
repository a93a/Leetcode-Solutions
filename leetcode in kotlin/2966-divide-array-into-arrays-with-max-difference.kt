class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val nums = nums.sorted().chunked(3)

        if (nums.any { it[2] - it[0] > k })
            return arrayOf()

        return nums.map { it.toIntArray() }.toTypedArray()
    }
}
