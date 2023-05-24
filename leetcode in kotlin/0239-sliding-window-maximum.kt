class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var res = IntArray(nums.size - k + 1)
        var resPos = 0

        var win = LinkedList<Int>()
        for (i in 0 until nums.size) {
            while (win.isNotEmpty() && nums[win.peekLast()] < nums[i])
                win.removeLast()
            win.addLast(i)
            if (win.peekFirst() == i - k)
                win.removeFirst()
            if (i >= k - 1)
                res[resPos++] = nums[win.peekFirst()]
        }

        return res
    }
