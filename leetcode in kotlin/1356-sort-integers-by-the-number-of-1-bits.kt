// use kotlin built in stuff
class Solution {
    fun sortByBits(arr: IntArray) = arr.sortedWith(
            Comparator { a, b ->
                val ab = a.countOneBits()
                val bb = b.countOneBits()
                if (ab == bb)
                    a - b
                else
                    ab - bb
            }
        ).toIntArray()
}

// same idea but implement everything yourself
class Solution {
    fun sortByBits(a: IntArray): IntArray {     
        mergeSort(a, 0, a.lastIndex)
        return a
    }

    private fun mergeSort(a: IntArray, l: Int, r: Int) {
        val size = r - l + 1
        if (size == 1) return

        val m = l + (r - l) / 2
        mergeSort(a, l, m)
        mergeSort(a, m + 1, r)
        merge(a, l, m, r)
    }

    private fun merge(a: IntArray, l: Int, m: Int, r: Int) {
        val left = a.copyOfRange(l, m + 1)
        val right = a.copyOfRange(m + 1, r + 1)
        var i = 0
        var j = 0
        var k = l

        while (i < left.size && j < right.size) {
            val leftBits = countBits(left[i])
            val rightBits = countBits(right[j])

            if (leftBits < rightBits) {
                a[k] = left[i]
                i++
            } else if (leftBits > rightBits) {
                a[k] = right[j]
                j++
            } else {
                if (left[i] < right[j]) {
                    a[k] = left[i]
                    i++
                } else {
                    a[k] = right[j]
                    j++
                }
            }
            k++
        }

        while (i < left.size) {
            a[k] = left[i]
            k++
            i++
        }
            

        while (j < right.size) {
            a[k] = right[j]
            k++
            j++
        }
    }

    private fun countBits(_a: Int): Int {
        var a = _a
        var count = 0
        while (a > 0) {
            if (a and 1 == 1)
                count++
            a = a shr 1
        }
        return count
    }
}
