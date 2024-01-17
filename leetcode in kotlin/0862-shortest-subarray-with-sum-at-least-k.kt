class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var pre = LongArray (nums.size + 1).apply {
            for (i in 1 until size)
                this[i] = this[i - 1] + nums[i - 1]
        }

        val mono = LinkedList<Int>()
        var res = Integer.MAX_VALUE
        for ((i, curSum) in pre.withIndex()) {
            while (mono.isNotEmpty() && curSum - pre[mono.peekFirst()] >= k)
                res = minOf(res, i - mono.removeFirst())

            while (mono.isNotEmpty() && curSum <= pre[mono.peekLast()])
                mono.removeLast()
            
            mono.addLast(i)
        }


        return if (res == Integer.MAX_VALUE) -1 else res
    }
}
