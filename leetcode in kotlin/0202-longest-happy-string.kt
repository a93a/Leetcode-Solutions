class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Pair<Char, Int>> { a, b ->
            b.second - a.second
         }.apply {
            add('a' to a)
            add('b' to b)
            add('c' to c)
        }

        val res = StringBuilder()
        while (maxHeap.isNotEmpty) {
            var (firstC, firstN) = q.poll()
            if (firstN > 1) {

            } else {
                
            }
        }
        
        return sb.toString()
    }
}
