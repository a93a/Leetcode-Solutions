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
    // solve this using floyd's tortoise and hare algorithm for cyclic detection
    fun hasCycle(head: ListNode?): Boolean {
        if(head == null) return false
        var fast = head; var slow = head
        while(fast != null && fast?.next != null){
            fast = fast?.next?.next
            slow = slow?.next
            if (slow == fast)
                return true
        }
        return false
    }
}
