class Solution {
    fun distinctDifferenceArray(nums: IntArray): IntArray {
        val count = IntArray(51)
        var suffixSize = 0
        val prefix = HashSet<Int>()

        for (n in nums) {
            if (count[n]++ == 0)
                suffixSize++
        }

        val res = IntArray(nums.size)
        for ((i, n) in nums.withIndex()) {
            prefix.add(n)
            if (--count[n] == 0)
                suffixSize--
            res[i] = prefix.size - suffixSize
        }

        return res
    }
}
