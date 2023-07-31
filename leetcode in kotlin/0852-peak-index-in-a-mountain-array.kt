class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var l = 0
        var r = arr.lastIndex

        while (l < r) {
            val m = (l + r) / 2
            if (arr[m] >= arr[m + 1])
                r = m
            else
                l = m + 1
        }

        return l
    }
}
