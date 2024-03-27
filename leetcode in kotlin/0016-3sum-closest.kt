// Bruteforce O(N^3) all possible pairs
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val n = nums.size
        var diff = Int.MAX_VALUE
        var res = 0
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in j + 1 until n) {
                    val sum = nums[i] + nums[j] + nums[k]
                    val newDiff = Math.abs(sum - target)
                    if (newDiff < diff) {
                        diff = newDiff
                        res = sum
                    }
                }
            } 
        }
        return res
    }
}

// O(n^2) sort and iterate with 2 pointers
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val n = nums.size
        nums.sort()
        var diff = Int.MAX_VALUE
        var res = 0
        for (i in 0 until n) {
            var l = i + 1
            var r = n - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                val newDiff = Math.abs(sum - target)
                if (newDiff < diff) {
                    diff = newDiff
                    res = sum
                }
                if (sum > target) r--
                else l++
            }
        }
        return res
    }
}
