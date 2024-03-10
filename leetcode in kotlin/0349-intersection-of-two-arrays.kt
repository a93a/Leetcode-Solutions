/*
 * A couple of different ways to solve it below
 */
class Solution {
    fun intersection(n1: IntArray, n2: IntArray): IntArray {
        val s1 = n1.toSet()
        val res = hashSetOf<Int> ()
        for (n in n2) {
            if (n in s1)
                res.add(n)
        }
        return res.toIntArray()
    }
}

class Solution {
    fun intersection(n1: IntArray, n2: IntArray) = n1
        .intersect(n2.asIterable())
        .toIntArray()
}

class Solution {
    fun intersection(n1: IntArray, n2: IntArray): IntArray {
        n1.sort()
        n2.sort()

        var i = 0
        var j = 0
        val res = hashSetOf<Int> ()
        while (i < n1.size && j < n2.size) {
            if (n1[i] > n2[j]) {
                j++
            } else if (n2[j] > n1[i]) {
                i++
            } else {
                res.add(n1[i++])
                j++
            }
        }

        return res.toIntArray()
    }
}
