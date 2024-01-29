class MyQueue() {
    
    val input = LinkedList<Int>()
    val output = LinkedList<Int>()

    fun push(x: Int) {
        input.addLast(x)
    }

    fun pop(): Int {
        if (output.isEmpty() ){
            refill()
        } 
        return output.removeLast()
    }

    fun peek(): Int {
        if(output.isEmpty()){
            refill()
        } 
        return output.peekLast()
    }

    private fun refill() {
        while (input.isNotEmpty())
            output.addLast(input.removeLast())
    }

    fun empty() = input.isEmpty() && output.isEmpty()

}
