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
