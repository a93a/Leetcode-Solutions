class Solution {
    fun minOrAfterOperations(nums: IntArray, k: Int): Int {
        var res = 0
        var mask = 0

        for (i in 29 downTo 0) {
            val bit = (1 shl i)
            mask = mask or bit

            var curMask = mask
            var countBits = 0
            for (n in nums) {
                curMask = curMask and n
                if (curMask or res != res) 
                    countBits++
                else 
                    curMask = mask
            }

            if (countBits > k) res = res or bit
        }

        return res
    }
}
