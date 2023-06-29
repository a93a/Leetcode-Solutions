class Solution {
    fun shortestPathAllKeys(g: Array<String>): Int {
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )
        
        fun isValid(i: Int, j: Int) = i in g.indices && j in g[0].indices && g[i][j] != '#'
        
        data class State(val i: Int, val j: Int, val keys: Int)
        val visit = HashSet<String>()
        val q = LinkedList<State>()

        var allKeys = 0
        for (i in g.indices) {
            for (j in g[0].indices) {
                if (g[i][j] == '@') {
                    q.addLast(State(i, j, 0))
                    visit.add("$i:$j:0")
                } else if (g[i][j] in 'a'..'f') {
                    allKeys = allKeys or (1 shl (g[i][j] - 'a'))
                }
            }
        }

        return with (q) {
            var steps = 0 
            while (isNotEmpty()) {
                repeat (size) {
                    val (i, j, keys) = removeFirst()
                    if (keys == allKeys) return steps
                    for (dir in dirs) {
                        val i2 = i + dir[0]
                        val j2 = j + dir[1]
                        if (isValid(i2, j2)) {
                            val c = g[i2][j2]
                            var newKeys = keys
                            if (c in 'A'..'F' && ((keys shr (c - 'A')) and 1) == 0) continue
                            else if (c in 'a'..'f') newKeys = (keys or (1 shl (c - 'a')))
                            val next = "$i2:$j2:$newKeys"
                            if (next !in visit) {
                                visit.add(next)
                                addLast(State(i2, j2, newKeys))
                            }
                        }
                    }
                }
                steps++
            }
            -1
        }
    }
}
