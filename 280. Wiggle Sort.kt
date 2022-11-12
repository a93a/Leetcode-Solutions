class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        for(i in 0 until nums.size-1){
            if(i%2 == 0 && nums[i] > nums[i+1]) //even (low)
                nums.swap(i,i+1)      
            if(i%2 != 0 && nums[i] < nums[i+1]) //even (low)
                nums.swap(i,i+1)
        }
    }
    
    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
