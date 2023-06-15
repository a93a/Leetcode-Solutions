/*
 * DFS
 */
class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        val levelSum = HashMap<Int, Int>()

        fun dfs(root: TreeNode?, level: Int) {
            root ?: return
            levelSum[level] = levelSum.getOrDefault(level, 0) + root.value
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        }

        dfs(root, 1)

        var max = Integer.MIN_VALUE
        var maxLevel = -1
        for ((k, v) in levelSum) {
            if (v > max) {
                max = v
                maxLevel = k
            }
        }

        return maxLevel
    }

    val TreeNode.value 
        get()= this.`val`
}

/*
 * BFS
 */
 class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        var maxSum = Integer.MIN_VALUE
        var maxLevel = 1
        var curLevel = 1

        with (LinkedList<TreeNode?>()) {
            addLast(root)

            while (isNotEmpty()) {
                var levelSum = 0

                repeat (size) {
                    val curr = removeFirst()
                    curr?.let {
                        levelSum += it.value
                        it.left?.let { addLast(it) }
                        it.right?.let { addLast(it) }
                    }
                }

                if (levelSum > maxSum) {
                    maxSum = levelSum
                    maxLevel = curLevel
                }

                curLevel++
            }
        }

        return maxLevel
    }

    val TreeNode.value 
        get()= this.`val`
}
