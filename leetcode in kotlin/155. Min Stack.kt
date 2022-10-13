class MinStack() {
    val stack = ArrayDeque<Pair<Int,Int>>() // value, minSoFar

    fun push(`val`: Int) {
        if(stack.isEmpty()) 
            stack.push(`val` to `val`)
        else
            stack.push(`val` to minOf(`val`, stack.peek().second))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
