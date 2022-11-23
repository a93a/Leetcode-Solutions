class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>() // "index" to "height"
        var max = 0
        
        for((i,h) in heights.withIndex()) {
            var start = i
            // pop until backlog h is atleast same as current h, set that i as new start i of h
            while(!stack.isEmpty() && stack.peek().second > h) {
                val (popI, popH) = stack.pop()
                max = maxOf(max, popH * (i - popI))
                start = popI
            }
            stack.push(start to h)
        }
        
        //leftover heights that extend to end of heights array
        while(!stack.isEmpty()) {
            val (i, h) = stack.pop()
            max = maxOf(max, h * (heights.size - i))
        }
        
        return max
    }
}
