class Solution {
    fun sumIndicesWithKSetBits(nums: List<Int>, k: Int) = nums.withIndex()
        .filter { it.index.countOneBits() == k }
        .sumBy { it.value }
}
