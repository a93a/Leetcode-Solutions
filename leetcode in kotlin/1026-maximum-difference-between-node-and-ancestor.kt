class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {
        var res = -1

        fun dfs(root: TreeNode?, max: Int, min: Int) {
            root?: return

            val newMax = maxOf(max, root.`val`)
            val newMin = minOf(min, root.`val`)

            res = maxOf(
                res,
                Math.abs(newMax - newMin),
                Math.abs(newMin - newMax)
            )

            dfs(root.left, newMax, newMin)
            dfs(root.right, newMax, newMin)
        }

        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
        return res
    }
}
