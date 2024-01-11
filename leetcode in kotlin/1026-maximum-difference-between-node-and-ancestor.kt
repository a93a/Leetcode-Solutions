class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {

        fun dfs(root: TreeNode?, max: Int, min: Int): Int {
            root?: return max - min

            val newMax = maxOf(max, root.`val`)
            val newMin = minOf(min, root.`val`)

            return maxOf(
                dfs(root.left, newMax, newMin),
                dfs(root.right, newMax, newMin)
            )         
        }

        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
    }
}
