class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy: ListNode? = ListNode(0)
        dummy?.next = head

        var leftP = dummy 
        var rightP = head
        repeat (n) {
            rightP = rightP?.next 
        }

        while (rightP != null) {
            leftP = leftP?.next
            rightP = rightP?.next
        }

        leftP?.next = leftP?.next?.next
        return dummy?.next
    }
}
