class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        permute(0, nums, res)
        return res
    }
    private fun permute(index: Int, nums: IntArray, res: ArrayList<ArrayList<Int>>){
        if(index == nums.size)
            res.add(nums.toCollection(ArrayList()))
        for(i in index until nums.size){
            nums.swap(index, i)
            permute(index+1, nums, res)
            nums.swap(index,i)
        }
    }
    private fun IntArray.swap(i: Int, j: Int){
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
