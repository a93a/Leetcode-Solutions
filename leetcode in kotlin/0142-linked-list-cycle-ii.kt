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

    fun detectCycle(head: ListNode?): ListNode? {

        var fast = head 

        var slow = head 

        var slow2 = head 

         

        while(fast != null && fast.next != null) { 

            fast = fast.next?.next 

            slow = slow?.next 

            if(slow == fast) break 

        } 

        

        if(fast == null || fast?.next == null) return null

         

        while(slow != null) {

            if(slow == slow2) 

                break 

            slow = slow.next

            slow2 = slow2?.next

        }

        return slow

    } 

}
