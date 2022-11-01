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
    
    // can also reverse list, delete, re-reverse, or count nodes, and jump to nth, delete, etc
    //but this way we only traverse the list once
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var leftP = dummy // we use dummy node to end iteration at the node just before Nth Node
        // so that we can easily delete Nth node by having prev node before Nth point to next node after N:th
        var rightP = head
        for(i in 0 until n){
            rightP = rightP!!.next // we are guaranteed not null
        }
        while(rightP != null){
            leftP = leftP.next
            rightP = rightP.next
        }
        leftP.next = leftP.next.next
        return dummy.next
    }
}
