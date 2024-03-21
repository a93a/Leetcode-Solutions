class Solution {
    fun unmarkedSumArray(n: IntArray, q: Array<IntArray>): LongArray {
        val res = LongArray (q.size)
        val min = PriorityQueue<IntArray> { a, b -> 
            if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0]
        }

        var sum = 0L
        for ((i, x) in n.withIndex()) {
            sum += x
            min.add(intArrayOf(x, i))
        }

        var r = 0
        q.forEach { (i, k) ->
            sum -= if (n[i] != -1) n[i] else 0
            n[i] = -1

            var p = 0
            while (min.isNotEmpty() && p < k) {
                val (_, j) = min.poll()
                if (n[j] == -1) continue
                sum -= if (n[j] != -1) n[j] else 0
                n[j] = -1
                p++
            }

            res[r++] = sum
        }

        return res
    }
}
