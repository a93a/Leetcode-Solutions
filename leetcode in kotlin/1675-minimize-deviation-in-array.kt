class Solution {
    fun minimumDeviation(nums: IntArray): Int {

        // minHeap with pair of N to it's maximum value X that N can get to.
        // For odd Numbers, N = N and X = 2 * N
        // For even numbers, N = N/2 until it's odd, X = N
        val minHeap = PriorityQueue<Pair<Int, Int>> {a,b -> a.first - b.first} 
        var heapMax = 0
        var res = Integer.MAX_VALUE

        // O(nlogm)
        for(_num in nums) {
            var num = _num
            while(num % 2 == 0) {
                num /= 2
            }
            minHeap.add(num to maxOf(_num, 2 * num))
            heapMax = maxOf(heapMax, num)
        }

        // O(nlogm * logn)
        while(minHeap.size == nums.size) {
            val (n, nMax) = minHeap.poll()
            res = minOf(res, heapMax - n) 
            if(n < nMax) {
                minHeap.add(n * 2 to nMax)
                heapMax = maxOf(heapMax, n * 2)
            }
        }

        return res
    }
}
