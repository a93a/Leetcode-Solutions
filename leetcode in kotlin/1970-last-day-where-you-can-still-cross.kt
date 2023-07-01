//bfs
class Solution {
    fun latestDayToCross(row: Int, col: Int, c: Array<IntArray>): Int {
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun isValid(i: Int, j: Int) = i in (0 until row) && j in (0 until col)

        fun canReach(mid: Int): Boolean {
            val m = Array (row) { IntArray (col) }
            for (i in 0 until mid) {
                val x = c[i][0]
                val y = c[i][1]
                m[x - 1][y - 1] = 1
            }

            return with (LinkedList<IntArray>()) {                
                for (i in 0 until col) {
                    if (m[0][i] == 0) {
                        m[0][i] == 1
                        addLast(intArrayOf(0, i))
                    }
                }

                while (isNotEmpty()) {
                    val (x, y) = removeFirst()
                    if (x == row - 1) return true
                    for (dir in dirs) {
                        val nX = x + dir[0]
                        val nY = y + dir[1]
                        if (isValid(nX, nY) && m[nX][nY] == 0) {
                            m[nX][nY] = 1
                            addLast(intArrayOf(nX, nY))
                        }
                    }
                }
                false
            }
        }

        var left = 1
        var right = c.size
        while (left <= right) {
            val mid = (left + right) / 2
            if (canReach(mid)) {
                left = mid + 1
            } else
                right = mid - 1
        }

        return left - 1
    }
}

//union find
