class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        var set = HashSet<Int>()
        for(i in nums){
            if(set.contains(i))
                return true
            set.add(i)
        }
        return false    
    }
}
