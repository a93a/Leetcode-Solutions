class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val win = LinkedList<Int>().apply { add(0) }

        for (i in 1 until nums.size) {
            if (win.peekFirst() + k < i)
                win.removeFirst()
            nums[i] += nums[win.peekFirst()]
            while (win.isNotEmpty() && nums[win.peekLast()] <= nums[i])
                win.removeLast()
            win.addLast(i)
        }

        return nums[nums.lastIndex]
    }
}
