class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        deck.sortDescending()

        val q = LinkedList<Int>()
        for (d in deck) {
            if (q.isNotEmpty()) q.addFirst(q.removeLast())
            q.addFirst(d)
        }

        return q.toIntArray()
    }
}
