class Solution {
    
    //use a "bucket sort" (but indexes as count) and val == which elements that occurs "index" times
    // Time complexity is O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val hm = HashMap<Int, Int>()
        val bsa = MutableList<ArrayList<Int>>(nums.size+1){arrayListOf()} // 1 to n, inverted "bucket sorted array"
        val res = ArrayList<Int>()
        
        for(n in nums)
            hm[n] = hm.getOrDefault(n, 0) + 1
        
        for((v,c) in hm)
            bsa.get(c).add(v)
            
        outerLoop@ for(i in bsa.size-1 downTo 1){
            for(n in bsa.get(i)){
                res.add(n)
                if(res.size == k)
                    break@outerLoop
            }
        }
        return res.toIntArray()
    }
}
