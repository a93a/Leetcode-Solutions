class Solution {
    fun averageOfSubtree(root: TreeNode?): Int {
        var res = 0

        fun preOrder(node: TreeNode?): Pair<Double, Int> {
            node?: return 0.0 to 0

            val (leftSum, leftCount) = preOrder(node.left)
            val (rightSum, rightCount)= preOrder(node.right)
            val subTreeSum = (leftSum + rightSum + node.`val`)
            val subTreeCount = (leftCount + rightCount + 1)

            if ((subTreeSum / subTreeCount).toInt() == node.`val`)
                res++
            
            return subTreeSum to subTreeCount
        }

        preOrder(root)
        return res
    }
}
