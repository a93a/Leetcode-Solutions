class Solution {
    fun reorderList(head: ListNode?): Unit {
        val q1 = LinkedList<ListNode?> ()
        val q2 = LinkedList<ListNode?> ()

        var slow = head
        var fast = head
        while (fast?.next != null) {
            q1.addLast(slow)
            slow = slow?.next
            fast = fast?.next?.next
        }

        while (slow != null) {
            q2.addFirst(slow)
            slow = slow?.next
        }

        val dummy: ListNode? = ListNode (-1)
        var cur = dummy
        while (q1.isNotEmpty()) {
            cur?.next = q1.removeFirst()
            cur = cur?.next
            cur?.next = q2.removeFirst()
            cur = cur?.next
            cur?.next = null
        }

        if (q2.isNotEmpty()) {
            cur?.next = q2.removeFirst()
            cur?.next?.next = null
        }

    }
}
