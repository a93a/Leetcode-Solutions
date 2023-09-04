class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        head?: return false

        var fast = head
        var slow = head
        while (fast != null && fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
            if (slow == fast) return true
        }

        return false
    }
}
