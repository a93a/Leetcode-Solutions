class Solution {  
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        val bucket = MutableList<ArrayList<Int>> (nums.size+1) { arrayListOf() } 
        val res = ArrayList<Int>()
        
        for (n in nums)
            count[n] = count.getOrDefault(n, 0) + 1
        
        for ((value,cnt) in count)
            bucket.get(cnt).add(value)
            
        outer@ for (i in bucket.lastIndex downTo 1) {
            for (n in bucket.get(i)) {
                res.add(n)
                if (res.size == k)
                    break@outer
            }
        }

        return res.toIntArray()
    }
}
