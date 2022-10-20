//quick select solution with average O(n) (and worstcase O(n^2) but rarely close to this)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val kIndex = nums.size - k - 1 // The index number of the K largest number from the end (smaller <- array index -> larger)
        return quickSelect(0, nums.size-2, kIndex, nums) // we choose rightmost as pivot => nums.size-1-1
    }
    private fun quickSelect(l: Int, r: Int, k: Int, nums: IntArray): Int{
        var pivot = nums[r]; var p = l //we choose rightmost as pivot
        for(i in l until r){
            if(nums[i] <= pivot){ // if its smaller than pivot...
                //...we add to left. IF larger, we "add" to right by leaving it
                val temp = nums[p]
                nums[p] = nums[i]
                nums[i] = temp
                p++
            }
        }
        // change the pivot place to the end of left portion of array...
        val temp = nums[p]
        nums[p] = nums[r]
        nums[r] = temp
        // ...we have partioned the array as [smaller than pivot unordered: pivot: larger than pivot unordered]
        if(p > k) // our index is larger than kth largest
            return quickSelect(l, p-1, k, nums) // we check left portion to find our index
        else if(p < k) // our index is smaller than kth largest
            return quickSelect(p+1, l, k, nums) // we check right portion to find our index
        else // p == k, our index is the kth largest index
            return nums[p]
    }
}

//another way of doing it in O(nlogn)
//using a heap
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>{a,b -> b - a}
        for(num in nums)
            maxHeap.add(num)
        repeat(k-1){    //remove the k-1 largest elements
            maxHeap.poll()
        }
        return maxHeap.poll() //kth largest element
    }
}

//"cheat solution" with average O(nlogn)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k-1]
    }
}
