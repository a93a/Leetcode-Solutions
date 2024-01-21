class Solution {
    fun minimumPushes(word: String): Int {
        val counts = word
            .groupingBy { it }
            .eachCount()
            .values
            .sortedBy { -it }

        var res = 0
        counts.withIndex().forEach { (i, count) ->
            res += ((i / 8) + 1) * count
        }

        return res
    }
}
