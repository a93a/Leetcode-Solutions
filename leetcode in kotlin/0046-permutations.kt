class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()

        fun perm(i: Int) {
            if (i == nums.size) {
                res.add(nums.toCollection(ArrayList()))
                return
            }

            for (j in i until nums.size) {
                nums.swap(i, j)
                perm(i + 1)
                nums.swap(i, j)
            }
        }

        perm(0)
        return res
    }

    fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }
}
