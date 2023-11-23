// O(m * n)
class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val res = mutableListOf<Boolean>()

        outer@ for ((i, j) in l.zip(r)) {
            if (j - i < 2) {
                res.add(true)
                continue@outer
            }

            var min = Integer.MAX_VALUE
            var max = Integer.MIN_VALUE
            val set = HashSet<Int>()
            for (k in i..j) {
                min = minOf(min, nums[k])
                max = maxOf(max, nums[k])
                set.add(nums[k])
            }

            if (min == max) {
                res.add(true)
                continue@outer
            }

            val d = (max - min) / (j - i)
            if ((max - min) % (j - i) != 0) {
                res.add(false)
                continue@outer
            }

            for (k in 1..(j - i)) {
                if (!set.contains(min + k * d)) {
                    res.add(false)
                    continue@outer
                }
            }

            res.add(true)
        }

        return res
    }
}

// O(m * nlogn)
class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val n = nums.size
        val m = l.size
        val res = MutableList<Boolean> (m) { true }
        for (i in 0 until m) {
            val arr = nums.copyOfRange(l[i], r[i] + 1)
            arr.sort()
            val diff = arr[1] - arr[0]
            for (j in 2 until arr.size) {
                if (arr[j] - arr[j - 1] != diff)
                    res[i] = false
            }
        }
        return res
    }
}

// O(m * nlogn)
// Same as above but with less code with Kotlin functions
class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray) = l.zip(r)
        .map { (i, j) ->
            val list = nums.copyOfRange(i, j + 1).toList().sorted()
            list.windowed(2).all { it[1] - it[0] == list[1] - list[0] }
        }
}
