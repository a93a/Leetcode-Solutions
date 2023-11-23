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

// less code with Kotlin functions
class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray) = l.zip(r)
        .map { (i, j) ->
            val list = nums.copyOfRange(i, j + 1).toList().sorted()
            list.windowed(2).all { it[1] - it[0] == list[1] - list[0] }
        }
}
