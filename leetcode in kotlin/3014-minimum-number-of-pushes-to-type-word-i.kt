// greedy
class Solution {
    fun minimumPushes(word: String): Int {
        var res = 0

        for (i in word.indices) {
            res += (i / 8) + 1
        }   

        return res
    }
}

// Count & Sort by most frequent and count total pushes
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
