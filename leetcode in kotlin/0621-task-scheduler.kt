// Use a priorityqueue
class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0)
            return tasks.size

        val hm = HashMap<Char,Int> ()
        for (task in tasks)
            hm[task] = hm.getOrDefault(task, 0) + 1     

        val maxHeap = PriorityQueue<Int> (compareBy{ -it })
        for (count in hm.values)
            maxHeap.add(count) 

        val q = ArrayDeque<Pair<Int,Int>> ()
        var time = 0
        while (maxHeap.isNotEmpty() || q.isNotEmpty()) {
            if (maxHeap.isNotEmpty()) {
                var current = maxHeap.poll()
                current--
                if (current > 0)
                    q.addLast((time + n) to current)
            }

            if (q.isNotEmpty()) {
                if (q.first().first == time)
                    maxHeap.add(q.removeFirst().second)
            }

            time++
        }    

        return time          
    }
}
