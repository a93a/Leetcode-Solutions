class Solution {
    fun findMode(root: TreeNode?): IntArray {
        val res = hashSetOf<Int>()
        var maxCount = 0
        var cur = root
        var curCount = 0
        
        fun inOrder(node: TreeNode?) {
            node?: return

            inOrder(node.left)

            if (node.`val` == cur?.`val`) {
                curCount++
            } else {
                cur = node
                curCount = 1
            }

            if (curCount > maxCount) {
                res.clear()
                res.add(node.`val`)
                maxCount = curCount
            } else if (curCount == maxCount) {
                res.add(node.`val`)
            }   

            inOrder(node.right)
        }

        inOrder(root)
        return res.toIntArray()
    }
}
