// time O(n)
class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray (n + 1)

        for (i in 1..n) {
            res[i] = res[i / 2] + (i and 1)
        }

        return res
    }


// time O(nlogn)
class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray (n + 1)

        res[0] == 0
        for (i in 1..n) {
            var j = i
            var count = 0

            while (j != 0) {
                if (j and 1 == 1) count++
                j = j shr 1
            }

            res[i] = count
        }

        return res
    }
}
