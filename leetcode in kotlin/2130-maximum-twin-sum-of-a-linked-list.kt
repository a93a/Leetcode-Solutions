/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        var slow = head
        var fast = head
        var prev: ListNode? = null

        while (fast != null && fast.next != null) {
            fast = fast.next.next
            val temp = slow?.next
            slow?.next = prev
            prev = slow
            slow = temp
        }

        var res = 0
        while (slow != null && prev != null) {
            res = maxOf(
                res, 
                (slow.value?: 0) + (prev.value?: 0)
            )
            prev = prev.next
            slow = slow.next
        }

        return res
    }

    val ListNode.value get()= this.`val`
}
