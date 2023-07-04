class Solution {
    fun singleNumber(nums: IntArray): Int {
        var set1 = 0
        var set2 = 0
        for (n in nums) {
            set1 = (set1 xor n) and set2.inv()
            set2 = (set2 xor n) and set1.inv()
        }
        return set1
    }
}
