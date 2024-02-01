// Solution 1. Time O(nlogn) and space O(n)
class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val nums = nums
            .sorted()
            .chunked(3)
            .map { it.toIntArray() }
            .toTypedArray()

        return if (nums.any { it[2] - it[0] > k }) arrayOf() else nums
    }
}

// Solution 2, same logic but make use of takeUnless. Time O(nlogn) and space O(n)
class Solution {
    fun divideArray(nums: IntArray, k: Int) = nums
        .sorted()
        .chunked(3)
        .toTypedArray()
        .takeUnless {
            it.any { it[2] - it[0] > k }
        } ?: arrayOf()
}

// "Counting sort". Time O(n) and space O(n)
class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val n = nums.size
        var freq = IntArray (100001)
        var min = nums.min() ?: 0
        var max = nums.max() ?: 100001

        for (n in nums)
            freq[n]++

        val sortedNums = mutableListOf<Int>()
        for (i in min..max) {
            if (freq[i] > 0) {
                for (j in 0 until freq[i])
                    sortedNums.add(i)
            }
        }

        var res = Array (n / 3) { IntArray (3) }
        for (i in 0 until n step 3) {
            if (sortedNums[i + 2] - sortedNums[i] > k)
                return arrayOf()
            res[i / 3][0] = sortedNums[i]
            res[i / 3][1] = sortedNums[i + 1]
            res[i / 3][2] = sortedNums[i + 2]
        }

        return res
    }
}
