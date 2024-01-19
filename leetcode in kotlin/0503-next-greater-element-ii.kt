class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray (n) { -1 }
        val stack = LinkedList<Int>()
        var j = 0

        for (i in 0 until 2 * n) {
            while (stack.isNotEmpty() && nums[i % n] > nums[stack.peekLast()])
                res[stack.removeLast()] = nums[i % n]
            stack.addLast(i % n)
        }

        return res
    }
}
