class Solution {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        var win = LinkedList<Int>()

        var res = Integer.MIN_VALUE
        for (i in 0 until nums.size) {
            nums[i] += (win.peekFirst() ?: 0)
            res = maxOf(res, nums[i])

            while (win.isNotEmpty() && win.peekLast() < nums[i])
                win.removeLast()
            if (nums[i] > 0)
                win.addLast(nums[i])
            if (i >= k && win.isNotEmpty() && win.peekFirst() == nums[i - k])
                win.removeFirst()
        }

        return res
    }
}
