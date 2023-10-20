class NestedIterator(nestedList: List<NestedInteger>) {

    val stack = LinkedList<NestedInteger>()

    init {
        stack.addAll(nestedList.reversed())
    }
    
    fun next(): Int {
        return stack.removeLast().getInteger()
    }
    
    fun hasNext(): Boolean {
        while (stack.isNotEmpty() && !stack.peekLast().isInteger()) {
            stack.addAll(stack.removeLast().getList().reversed())
        }

        return stack.isNotEmpty()
    }
}
