// binary searc
class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val n = arr.size
        val j = n / 4
        var indices = listOf(n / 4, n / 2, (3 * n) / 4)

        for (i in indices) {
            val first = arr.firstIndex(arr[i])
            if (arr[first + j] == arr[i])
                return arr[i]
        }

        return -1
    }

    fun IntArray.firstIndex(x: Int): Int {
        var l = 0
        var r = lastIndex
        while (l < r) {
            val m = l + (r - l) / 2
            if (this[m] == x && (m == l || this[m - 1] < x))
                return m
            if (x > this[m])
                l = m + 1
            else
                r = m
        }
        return l
    }

}

// linear search
class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val n = arr.size
        val j = n / 4

        for (i in 0 until n - j) {
            if (arr[i] == arr[i + j])
                return arr[i]
        }

        return -1
    }

}
