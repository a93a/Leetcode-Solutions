class Solution {
    fun closeStrings(w1: String, w2: String): Boolean {
        val m1 = IntArray (26)
        for (c in w1)
            m1[c - 'a']++

        val m2 = IntArray (26)
        for (c in w2)
            m2[c - 'a']++
        
        for (i in 0 until 26) {
            if (m1[i] != m2[i] && (m1[i] == 0 || m2[i] == 0))
                return false
        }

        m1.sort()
        m2.sort()

        return m1 contentEquals m2
    }
}
