/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
 class KthLargest(k: Int, nums: IntArray) {
    val minHeap = PriorityQueue<Int>{ a: Int, b: Int ->
        a - b
    }
    var k = Integer.MIN_VALUE
    init{
        this.k = k
        for(num in nums)
            minHeap.add(num)
        while(minHeap.size > k)
            minHeap.poll()
    }
    fun add(`val`: Int): Int {
        minHeap.add(`val`)
        if(minHeap.size > k)
            minHeap.poll()
        return minHeap.peek()
    }

}
