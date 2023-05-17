class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var left = 0
        var right = costs.lastIndex
        val canL = PriorityQueue<Int>()
        val canR = PriorityQueue<Int>()

        var res = 0L
        var n = k
        while (n > 0) {
            while (canL.size < candidates && left <= right) canL.add(costs[left++])
            while (canR.size < candidates && left <= right) canR.add(costs[right--])

            if (canL.peek()?: 100001 <= canR.peek()?: 100001) {
                res += canL.poll()
            } else {
                res += canR.poll()
            }
            n--
        }

        return res
    }
}
