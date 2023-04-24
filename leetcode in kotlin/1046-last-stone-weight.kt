class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val q = PriorityQueue<Int>{a,b -> b - a}

        for (s in stones)
            q.add(s)

        while (q.size > 1)
            q.add(q.poll() - q.poll())

        return q.peek()
    }
}
