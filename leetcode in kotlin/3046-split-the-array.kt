class Solution {
    fun isPossibleToSplit(nums: IntArray): Boolean {
        val freq = IntArray (101)
        for (n in nums) {
            freq[n]++
            if (freq[n] > 2) return false
        }
        return true
    }
}

// or kotlin style
class Solution {
    fun isPossibleToSplit(nums: IntArray) = nums
        .asIterable()
        .groupingBy { it }
        .eachCount()
        .all { it.value <= 2 }
}
