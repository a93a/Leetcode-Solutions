class MyQueue {
    LinkedList<Integer> in = new LinkedList<Integer>();
    LinkedList<Integer> out = new LinkedList<Integer>();
    
    public void push(int x) {
        in.addLast(x);
    }
    
    public int pop() {
        refill();
        return out.removeLast();
    }
    
    public int peek() {
        refill();
        return out.peekLast();
    }

    private void refill() {
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.addLast(in.removeLast());
        }
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
