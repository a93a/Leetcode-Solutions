class Solution {
    fun isPathCrossing(path: String): Boolean {
        var x = 0
        var y = 0
        val paths = HashSet<Pair<Int, Int>>().apply { add(0 to 0) }

        for (p in path) {
            when (p) {
                'N' -> if (++x to y in paths) return true
                'S' -> if (--x to y in paths) return true
                'E' -> if (x to ++y in paths) return true
                'W' -> if (x to --y in paths) return true
            }
            paths.add(x to y)
        }

        return false
    }
}

// alternativly change logic to not use Kotlin's when statement
class Solution {
    fun isPathCrossing(path: String): Boolean {
        var dirs = mapOf(
            'N' to intArrayOf(0, 1),
            'S' to intArrayOf(0, -1),
            'E' to intArrayOf(1, 0),
            'W' to intArrayOf(-1, 0),
        )
        val visit = HashSet<Pair<Int, Int>>()
        var x = 0
        var y = 0

        for (c in path) {
            visit.add(x to y)
            val (dx, dy) = dirs[c]!!
            x += dx
            y += dy
            if ((x to y) in visit)
                return true
        }

        return false
    }
}
