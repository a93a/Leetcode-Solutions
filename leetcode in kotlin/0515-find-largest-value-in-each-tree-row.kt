// Level order BFS
class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        root?: return listOf<Int>()
        
        val maxes = HashMap<Int, Int>()

        with (LinkedList<TreeNode?>()) {
            addLast(root)
            var level = 0

            while (isNotEmpty()) {
                repeat (size) {
                    val cur = removeFirst()
                    maxes[level] = maxOf(
                        cur?.value ?: Integer.MIN_VALUE, 
                        maxes.getOrDefault(level, Integer.MIN_VALUE)
                    )
                    cur?.left?.let { addLast(it) }
                    cur?.right?.let { addLast(it) }
                }

                level++
            }
        }

        return maxes.values.toList()
    }

    val TreeNode.value
        get()= this.`val`
}

// Pre order DFS (order does not matter here, can do pre/in/post)
class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        root?: return listOf<Int>()
        
        val maxes = HashMap<Int, Int>()

        fun dfs(cur: TreeNode?, level: Int) {
            cur?: return

            maxes[level] = maxOf(
                cur?.value ?: Integer.MIN_VALUE, 
                maxes.getOrDefault(level, Integer.MIN_VALUE)
            )

            dfs(cur?.left, level + 1)
            dfs(cur?.right, level + 1)
        }

        dfs(root, 0)
        return maxes.values.toList()
    }

    val TreeNode.value
        get()= this.`val`
}
