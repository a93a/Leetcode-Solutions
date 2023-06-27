class Solution {
    fun kSmallestPairs(a: IntArray, b: IntArray, k: Int): List<List<Int>> {
        var res = arrayListOf<ArrayList<Int>>()
        var minHeap = PriorityQueue<IntArray>{ a,b -> (a[0] + a[1]) - (b[0] + b[1]) }

        for (i in 0 until minOf(a.size, k))
            minHeap.add(intArrayOf(a[i], b[0], 0))
        
        var count = 0
        while (count < k && minHeap.isNotEmpty()) {
            var min = minHeap.poll()
            res.add(arrayListOf(min[0], min[1]))
            if (min[2] < b.lastIndex)
                minHeap.add(intArrayOf(min[0], b[min[2] + 1], min[2] + 1))
            count++
        }

        return res
    }
}
