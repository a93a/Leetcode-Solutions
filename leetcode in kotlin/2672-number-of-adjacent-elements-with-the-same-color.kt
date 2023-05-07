class Solution {
    fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {
        val nums = IntArray(n)

        val res = IntArray(queries.size)
        var count = 0
        for ((i, q) in queries.withIndex()) {
            val (e, c) = q
            
            if (e > 0 && nums[e] != 0 && nums[e - 1] == nums[e]) count--
            if (e < n - 1 && nums[e] != 0 && nums[e + 1] == nums[e]) count--

            nums[e] = c

            if (e > 0 && nums[e] != 0 && nums[e - 1] == nums[e]) count++
            if (e < n - 1 && nums[e] != 0 && nums[e + 1] == nums[e]) count++

            res[i] = count
        }

        return res
    }
}
