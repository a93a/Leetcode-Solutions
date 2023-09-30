class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b -> 
            if (a.first == b.first)
                a.second - b.second
            else
                a.first - b.first
        }

        for ((index, row) in mat.withIndex()) {
            var i = 0
            while (i < row.size && row[i] == 1) i++
            maxHeap.add(i to index)
        }

        return IntArray (k).apply {
            for (i in indices) {
                this[i] = (maxHeap.poll().second ?: 0)
            }
        }
    }
}
