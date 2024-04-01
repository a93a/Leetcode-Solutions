class Solution {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val count = HashMap<Int, Long>()
        val res = LongArray (nums.size)
        val heap = PriorityQueue<Pair<Long, Int>> (compareBy( { -it.first }, { it.second }))

        for (i in nums.indices) {
            val n = nums[i]
            val f = freq[i]
            count[n] = (count[n] ?: 0L) + f
            heap.add(count[n]!! to n)

            while (heap.isNotEmpty() && heap.peek().first != count[heap.peek().second])
                heap.poll()
            
            res[i] = heap.peek().first
        }

        return res
    }
}
