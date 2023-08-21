class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2
        var carry = 0
        val dummy = ListNode(0)
        var cur = dummy
        while (n1 != null || n2 != null || carry > 0) {
            val sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + carry
            carry = sum / 10
            val new = ListNode(sum % 10)
            cur?.next = new
            cur = cur?.next
            if (n1 != null) n1 = n1?.next
            if (n2 != null) n2 = n2?.next
        }

        return dummy?.next
    }
}
