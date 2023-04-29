class Solution {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        val q = PriorityQueue<Int>{a,b -> b - a}
        for (n in nums) q.add(n)
        
        var m = k
        var sum = 0
        while (m > 0 && q.isNotEmpty()) {
            val n = q.poll()
            sum += n
            q.add(n + 1)
            m--
        }
        
        return sum
    }
}
