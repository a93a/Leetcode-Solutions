class Solution {
    fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0

        fun postOrder(node: TreeNode?): Pair<Double, Int> {
            node?: return 0.0 to 0

            val (leftSum, leftCount) = postOrder(node.left)
            val (rightSum, rightCount)= postOrder(node.right)
            val subTreeSum = (leftSum + rightSum + node.`val`)
            val subTreeCount = (leftCount + rightCount + 1)

            if ((subTreeSum / subTreeCount).toInt() == node.`val`)
                res++
            
            return subTreeSum to subTreeCount
        }

        postOrder(root)
        return res
    }
}
