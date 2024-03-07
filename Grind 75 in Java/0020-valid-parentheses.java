class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char c : s.toCharArray()) {
            if(c == ')' && !stack.isEmpty() && stack.peekLast() == '(') {
                stack.removeLast();
            } else if(c == '}' && !stack.isEmpty() && stack.peekLast() == '{') {
                stack.removeLast();
            } else if(c == ']' && !stack.isEmpty() && stack.peekLast() == '[') {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.isEmpty();
    }
}
