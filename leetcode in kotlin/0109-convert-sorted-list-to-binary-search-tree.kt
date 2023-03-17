/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        head?: return null

        var size = 0
        var runner = head
        while(runner != null) {
            runner = runner?.next
            size++
        }

        var current = head

        fun helper(start: Int, end: Int): TreeNode? {
            if(start > end)
                return null
            
            val mid = (start + end) / 2

            val left = helper(start, mid - 1)
            val node = TreeNode(current!!.`val`)
            current = current?.next
            val right = helper(mid + 1, end)

            node.left = left
            node.right = right

            return node
        }

        return helper(0, size - 1)
    }

    val TreeNode.value get()= this.`val`
}
