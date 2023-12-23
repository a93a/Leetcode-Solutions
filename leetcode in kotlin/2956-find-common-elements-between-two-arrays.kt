class Solution {
    fun findIntersectionValues(n1: IntArray, n2: IntArray): IntArray {
        val f1 = IntArray (101)
        val f2 = IntArray (101)

        for (n in n1) f1[n]++
        for (n in n2) f2[n]++

        var res1 = 0
        var res2 = 0
        
        for (n in 1..100) {
            if (f1[n] > 0) res2 += f2[n]
            if (f2[n] > 0) res1 += f1[n]
        }

        return intArrayOf(res1, res2)
    }
}
