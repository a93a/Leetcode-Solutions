class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var res = 0L
        var maxI = 0
        var maxIJ = 0

        for (i in nums) {
            res = maxOf(res, maxIJ.toLong() * i)
            maxI = maxOf(maxI, i)
            maxIJ = maxOf(maxIJ, maxI - i)
        }

        return res
    }
}
