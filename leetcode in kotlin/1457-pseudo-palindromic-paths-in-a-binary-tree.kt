// Count odd at each leaf
class Solution {
    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        val counts = IntArray (10)

        fun dfs(node: TreeNode?): Int {
            node ?: return 0

            counts[node.`val`]++

            var res = 0
            if (node.left == null && node.right == null) 
                res = if (counts.count { it % 2 == 1 } <= 1) 1 else 0
            else
                res = dfs(node.left) + dfs(node.right)

            counts[node.`val`]--

            return res
        }

        return dfs(root)
    }
}

// small optimization is to keep track of odd
// This way you dont have to run O(10 * n / 2) ~ O(n) count operations
class Solution {
    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        val count = IntArray (10)
        var odd = 0

        fun dfs(node: TreeNode?): Int {
            node ?: return 0

            count[node.`val`]++
            val oddChange = if (count[node.`val`] % 2 == 1) 1 else -1
            odd += oddChange

            var res = 0
            if (node.left == null && node.right == null)
                res = if (odd <= 1) 1 else 0
            else
                res = dfs(node.left) + dfs(node.right)

            odd -= oddChange
            count[node.`val`]--

            return res
        }

        return dfs(root)
    }
}
