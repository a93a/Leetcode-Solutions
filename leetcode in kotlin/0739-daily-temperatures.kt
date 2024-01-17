class Solution {
    fun dailyTemperatures(t: IntArray): IntArray {
        val m = LinkedList<Int>() 
        val res = IntArray (t.size)

        var j = 0
        for (i in t.indices) {
            while (m.isNotEmpty() && t[m.peekLast()] < t[i])
                res[m.peekLast()] = i - m.removeLast()

            m.addLast(i)
        }

        return res
    }
}
