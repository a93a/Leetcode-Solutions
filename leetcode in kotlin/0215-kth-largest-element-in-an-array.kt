//quick select solution with average O(n) (and worstcase O(n^2) but rarely close to this)
class Solution {
    fun findKthLargest(nums: IntArray, _k: Int): Int {
        val k = nums.size - _k

        fun quickSelect(l: Int, r: Int): Int {
            val pivot = nums[r]
            var p = l
            for (i in l until r) {
                if (nums[i] <= pivot) {
                    nums.swap(i, p)
                    p++
                }
            }
            nums.swap(p, r)

            return if (p > k) quickSelect(l, p - 1)
            else if (p < k) quickSelect(p + 1, r)
            else nums[p]
        }

        return quickSelect(0, nums.lastIndex)   
    }

    fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }
}

//another way of doing it in O(nlogn)
//using a heap
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int> {a,b -> b - a}
        for (num in nums)
            maxHeap.add(num)
        repeat (k-1) {    //remove the k-1 largest elements
            maxHeap.poll()
        }
        
        return maxHeap.poll()
    }
}

//"cheat solution" with average O(nlogn)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k-1]
    }
}
