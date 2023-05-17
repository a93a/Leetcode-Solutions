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
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val q = LinkedList<TreeNode?>()
        val res = ArrayList<Double>()

        q.addFirst(root)
        while (q.isNotEmpty()) {
            var levelSum = 0.0
            var levelNodes = 0
            
            repeat(q.size) {
                val node = q.removeLast()

                levelNodes++
                levelSum += node?.`val`?: 0
                
                node?.left?.let { q.addFirst(node.left) }
                node?.right?.let { q.addFirst(node.right) }
            }

            res.add(levelSum / levelNodes)
        }

        return res.toDoubleArray()
    }
}
