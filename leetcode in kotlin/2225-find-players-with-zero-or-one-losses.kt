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
