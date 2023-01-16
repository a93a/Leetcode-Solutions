class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        
        val res = ArrayList<ArrayList<Int>>()     
        val temp = ArrayList<Int>()
        
        fun dfs(i: Int) {
            if(i == nums.size){
                res.add(ArrayList(temp))
                return
            }
            temp.add(nums[i])
            dfs(i+1)
            temp.remove(nums[i])
            dfs(i+1)
            
        }  
        dfs(0)
        return res
    }
}
