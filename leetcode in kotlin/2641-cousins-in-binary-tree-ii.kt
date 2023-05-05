/*
* BFS
*/
class Solution {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val levelSum = HashMap<Int, Int>()
        
        val q = ArrayDeque<Pair<TreeNode?, Int>>().apply {
            add(root to 1)

            while (isNotEmpty()) {
                val (node, depth) = poll()
                node?: continue
                levelSum[depth] = levelSum.getOrDefault(depth, 0) + node.`val`
                node.left?.let { add(node.left to depth + 1) }
                node.right?.let { add(node.right to depth + 1) }
            }
        }

        val q2 = ArrayDeque<Triple<TreeNode?, Int, Int>>().apply {
            add(Triple(root, root!!.`val`, 1))

            while (isNotEmpty()) {
                val (node, sum, depth) = poll()
                node?: continue
                node.`val` = levelSum[depth]!! - sum
                val childVal = node.childrenValue
                node.left?.let { add(Triple(node.left, childVal, depth + 1)) }
                node.right?.let { add(Triple(node.right, childVal, depth + 1)) }
            }
        }

        return root
    }


    val TreeNode.childrenValue
        get()= (this.left?.`val` ?: 0) + (this.right?.`val` ?: 0)
}

/*
* DFS
*/
class Solution {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val levelSum = HashMap<Int, Int>()

        fun getLevelSums(node: TreeNode?, depth: Int) {
            node?: return
            levelSum[depth] = levelSum.getOrDefault(depth, 0) + node.`val`
            node.left?.let { getLevelSums(node.left, depth + 1) }
            node.right?.let { getLevelSums(node.right, depth + 1) }
        }

        fun changeNodeVal(cur: TreeNode?, sum: Int, depth: Int) {
            cur?: return
            cur.`val` = levelSum[depth]!! - sum
            val childVal = cur.childrenValue
            cur.left?.let { changeNodeVal(cur.left, childVal, depth + 1) }
            cur.right?.let { changeNodeVal(cur.right, childVal, depth + 1) }
        }

        getLevelSums(root, 1)
        changeNodeVal(root, root!!.`val`, 1)
        return root
    }


    val TreeNode.childrenValue
        get()= (if (this.left != null) this.left.`val` else 0) + (if (this.right != null) this.right.`val` else 0)
}

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
