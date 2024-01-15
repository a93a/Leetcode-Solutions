// O(nlogn) time and O(n) space
class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = HashMap<Int, Int>()
        val losers = HashMap<Int, Int>()

        for ((w, l) in matches) {
            winners[w] = (winners[w] ?: 0) + 1
            losers[l] = (losers[l] ?: 0) + 1
        }

        return listOf(
            winners.filter { it.key !in losers }.map { it.key }.sorted(), 
            losers.filter { it.value == 1 }.map { it.key}.sorted()
        )
    }
}

// Optimized time O(n) and space O(n)
class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = IntArray (100001)
        val losers = IntArray (100001)

        for ((w, l) in matches) {
            winners[w]++
            losers[l]++
        }

        return listOf(
            winners.withIndex().filter { losers[it.index] == 0 && it.value != 0 }.map { it.index },
            losers.withIndex().filter { it.value == 1 }.map { it.index }
        )
    }
}

// DIY logic Optimized time O(n) and space O(n), without kotlin stuff
class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = IntArray (100001)
        val losers = IntArray (100001)

        for ((w, l) in matches) {
            winners[w]++
            losers[l]++
        }

        var res = listOf(
            mutableListOf<Int>(),
            mutableListOf<Int>()
        )

        for (i in 1..100000) {
            if (winners[i] != 0 && losers[i] == 0)
                res[0].add(i)
            else if (losers[i] == 1)
                res[1].add(i)
        }

        return res
    }
}

// Above solution but optimized from O(2 * n) down to O(n)
class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val scores = IntArray (100001)

        for ((w, l) in matches) {
            if (scores[l] < 0) scores[l]--
            if (scores[l] >= 0) scores[l] = -1
            if (scores[w] >= 0) scores[w] = 1
        }

        var res = listOf(
            mutableListOf<Int>(),
            mutableListOf<Int>()
        )

        for (i in 1..100000) {
            if (scores[i] == 1)
                res[0].add(i)
            else if (scores[i] == -1)
                res[1].add(i)
        }

        return res
    }
}
