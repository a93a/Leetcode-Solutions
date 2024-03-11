class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        HashSet<String> ops = new HashSet<>(Set.of("+", "-", "*", "/"));

        for (String t : tokens) {
            if (ops.contains(t)) {
                int second = stack.removeLast();
                int first = stack.removeLast();
                int sum = 0;

                switch (t) {
                    case "+":
                        sum = first + second;
                        break;
                    case "-":
                        sum = first - second;
                        break;
                    case "*":
                        sum = first * second;
                        break;
                    case "/":
                        sum = first / second;
                        break;
                }

                stack.addLast(sum);
            } else {
                stack.addLast(Integer.parseInt(t));
            }
        }

        return stack.removeLast();
    }
}
