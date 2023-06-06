/*
* O(nlogn)
*/
class Solution {
    fun canMakeArithmeticProgression(a: IntArray): Boolean {
        a.sort()
        val diff = a[1] - a[0]
        for (i in 2 until a.size) {
            if (a[i] - a[i - 1] != diff)
                return false
        }
        return true
    }
}

/*
* O(n)
*/
class Solution {
    fun canMakeArithmeticProgression(a: IntArray): Boolean {
        val min = a.min()!!
        val max = a.max()!!

        if ((max - min) % (a.size - 1) != 0) return false
        val diff = (max - min) / (a.size - 1)
        if (diff == 0) return true

        val set = HashSet<Int>().apply {
            for (n in a)
                add(n)
        }

        for ((i,n) in a.withIndex()) {
            if ((min + i * diff) !in set)
                return false
        }

        return true
    }
}
