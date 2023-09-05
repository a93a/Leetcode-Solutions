// convert tree to graph (dfs) and then bfs (min to reach all nodes)
class Solution {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val graph = HashMap<Int, MutableList<Int>>()

        fun buildGraph(cur: TreeNode?, par: TreeNode?) {
            par?.let {
                graph[cur!!.value] = graph.getOrDefault(cur!!.value, mutableListOf<Int>()).apply { 
                    add(par!!.value) 
                }
            }
            
            cur?.left?.let {
                graph[cur!!.value] = graph.getOrDefault(cur!!.value, mutableListOf<Int>()).apply { 
                    add(it.value) 
                }
                buildGraph(it, cur)
            }

            cur?.right?.let {
                graph[cur!!.value] = graph.getOrDefault(cur!!.value, mutableListOf<Int>()).apply { 
                    add(it.value) 
                }
                buildGraph(it, cur)
            }
        }

        buildGraph(root, null)

        var res = 0
        val visited = HashSet<Int>()
        with (LinkedList<Int>()) {
            addLast(start)
            visited.add(start)

            while (isNotEmpty()) {
                repeat (size) {
                    val cur = removeFirst()
                    graph[cur]?.forEach {
                        if (it !in visited) {
                            visited.add(it)
                            addLast(it)
                        }
                    }
                }
                res++
            }
        }

        return res - 1
    }

    val TreeNode.value
        get() = this.`val`
}

// dfs one pass and keep track of max length
class Solution {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        var maxL = 0

        fun dfs(root: TreeNode?): Int {
            root?: return 0

            val left = dfs(root.left)
            val right = dfs(root.right)

            if (root.`val` == start) {
                maxL = maxOf(left, right)
                return -1
            } else if (left > -1 && right > -1) {
                return maxOf(left, right) + 1
            } else {
                maxL = maxOf(maxL, Math.abs(left - right))
                return minOf(left, right) - 1
            }
        }

        dfs(root)
        return maxL
    }
}
