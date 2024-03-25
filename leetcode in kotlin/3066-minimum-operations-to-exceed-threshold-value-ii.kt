class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val min = PriorityQueue<Long>()
        nums.forEach { min.add(it.toLong()) }

        var res = 0
        while (min.size > 1 && min.peek() < k) {
            val a = min.poll()
            val b = min.poll()
            min.add(minOf(a, b) * 2 + maxOf(a, b))
            res++
        }
        
        return res
    }
}
