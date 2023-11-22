class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val diagonals = HashMap<Int, MutableList<Int>>()
        var maxDia = -1

        for (i in nums.lastIndex downTo 0) {
            val list = nums[i]
            for (j in 0 until list.size) {
                val d = i + j
                maxDia = maxOf(maxDia, d)
                diagonals.getOrPut(d) { mutableListOf<Int>() }.apply { add(list[j]) }
            }
        }

        val size = diagonals.values.sumBy { it.size }
        val res = IntArray (size)
        var i = 0
        for (key in 0..maxDia) {
            diagonals[key]?.let { values ->
                values.forEach { value ->
                    res[i++] = value
                }
            }
        }

        return res
    }
}
