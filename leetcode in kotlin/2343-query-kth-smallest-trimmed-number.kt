// Get all trimmed, sort and take kth element
class Solution {
    fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
        var res = IntArray (queries.size)
        var i = 0

        for ((k, trim) in queries) {
            var trimmed = mutableListOf<String>()

            for (n in nums)
                trimmed.add(n.takeLast(trim))
                
            res[i++] = trimmed
                .withIndex()
                .sortedBy { it.value }
                .get(k - 1)
                .index
        }

        return res
    }
}

// Radix sort (and counting sort)
class Solution {
    fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
        var sorted = Array<Pair<String, Int>> (nums.size) { "" to -1 }
        for ((i, num) in nums.withIndex())
            sorted[i] = num to i

        var res = IntArray (queries.size)
        val m = nums[0].length
        var qFound = 0
        for (radix in (m - 1) downTo 0) {
            if (qFound == queries.size) break
            
            sorted = countingSort(sorted, radix)
            var qIdx = 0

            for ((k, trim) in queries) {
                if (m - trim == radix) {
                    res[qIdx] = sorted[k - 1].second
                    qFound++;
                }
                qIdx++
            }
        }

        return res
    }

    private fun countingSort(nums: Array<Pair<String, Int>>, radix: Int): Array<Pair<String, Int>> {
        val buckets = IntArray (10)
        for (num in nums)
            buckets[num.first[radix] - '0']++

        for (i in 1..9)
            buckets[i] += buckets[i - 1]
        
        val res = Array<Pair<String, Int>>(nums.size) { "" to -1 }
        for (i in nums.lastIndex downTo 0) {
            res[--buckets[nums[i].first[radix] - '0']] = nums[i]
        }
            
        return res
    }
}
