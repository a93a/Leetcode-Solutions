class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        val adj = HashMap<Int, ArrayList<Int>>()

        fun buildGraph(node: TreeNode?, parent: TreeNode?) {
            node?: return
            parent?.let {
                adj[node.value] = adj.getOrDefault(node.value, ArrayList<Int>()).apply { 
                    add(it.value) 
                }
            }
            node.left?.let { 
                adj[node.value] = adj.getOrDefault(node.value, ArrayList<Int>()).apply { 
                    add(it.value) 
                }
                buildGraph(it, node) 
            }
            node.right?.let { 
                adj[node.value] = adj.getOrDefault(node.value, ArrayList<Int>()).apply { 
                    add(it.value) 
                }
                buildGraph(it, node) 
            }
        }

        buildGraph(root, null)
        val res = ArrayList<Int>()
        val visited = HashSet<Int>()

        with (LinkedList<Pair<Int, Int>>()) {
            addLast(target!!.value to 0)
            visited.add(target.value)
            while (isNotEmpty()) {
                val (node, len) = removeFirst()
                if (len == k) {
                    res.add(node)
                } else {
                    adj[node]?.forEach {
                        if (it !in visited) {
                            visited.add(it)
                            addLast(it to len + 1)
                        }
                    }
                }
            }
        }

        return res
    }

    val TreeNode.value
        get()= this.`val`
}
