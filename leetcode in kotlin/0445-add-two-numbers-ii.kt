class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = LinkedList<ListNode?>().apply {
            var cur = l1
            while (cur != null) {
                addFirst(cur)
                cur = cur?.next
            }
        }
        
        val stack2 = LinkedList<ListNode?>().apply {
            var cur = l2
            while (cur != null) {
                addFirst(cur)
                cur = cur?.next
            }
        }

        var dummy = ListNode(0)
        var carry = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry > 0) {
            val v1 = if (stack1.isNotEmpty()) stack1.removeFirst()!!.`val` else 0
            val v2 = if (stack2.isNotEmpty()) stack2.removeFirst()!!.`val` else 0
            val sum = carry + v1 + v2
            carry = sum / 10
            var new = ListNode(sum % 10)
            new.next = dummy.next
            dummy.next = new
        }

        return dummy!!.next
    }
}
