class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val minHeap = PriorityQueue<IntArray> { a, b -> a[2] - b[2] }
        val visited = HashSet<Pair<Int, Int>>()

        var minCost = 0
        minHeap.add(intArrayOf(points[0][0], points[0][1], 0))
        while (visited.size < points.size) {
            val (x, y, d) = minHeap.poll()
            if ((x to y) in visited) continue

            minCost += d
            visited.add(x to y)

            for ((x2, y2) in points) {
                val d2 = Math.abs(x2 - x) + Math.abs(y2 - y)
                minHeap.add(intArrayOf(x2, y2, d2))
            }
        }

        return minCost
    }
}
