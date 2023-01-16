class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        val temp = ArrayList<Int>()
        nums.sort()
        
        fun dfs(i: Int) {
            if(i == nums.size){
                res.add(ArrayList(temp))
                return
            }
            
            temp.add(nums[i])
            dfs(i+1)
            temp.remove(nums[i])
            
            var nI = i
            while(nI+1 < nums.size && nums[nI] == nums[nI+1]) // skip all duplicate numbers for the current set
                nI++
            dfs(nI+1)
        }
        dfs(0)
        return res
    }
}
