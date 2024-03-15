class MinStack {
    LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();
    
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty())
            min = Math.min(min, getMin());
        stack.addLast(new Pair(val, min));
    }
    
    public void pop() {
        stack.removeLast();
    }
    
    public int top() {
        return stack.peekLast().getKey();
    }
    
    public int getMin() {
        return stack.peekLast().getValue();
    }
}
