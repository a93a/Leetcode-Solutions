// Use a stack
class Solution {
    public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();

        ListNode cur = head;
        while (cur != null) {
            stack.addLast(cur);
            cur = cur.next;
        }
        
        ListNode dummy = new ListNode(0);
        cur = dummy;
        while (!stack.isEmpty()) {
            ListNode next = stack.removeLast();
            cur.next = next;
            cur = cur.next;
        }

        cur.next = null;
        return dummy.next;
    }
}

// In place
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
