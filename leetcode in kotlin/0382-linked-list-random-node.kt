/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution(private val head: ListNode?) {

    fun getRandom(): Int {
        var res = Integer.MIN_VALUE
        var n = 0
        var current = head

        while(current != null) {
            val random = (0..n).random()
            if(random == 0) res = current.value
            n++
            current = current?.next
        }

        return res
    }

    val ListNode.value get()= this.`val`
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */
