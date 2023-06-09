class Solution {
    fun nextGreatestLetter(a: CharArray, target: Char): Char {
        if (target < a[0] || target >= a[a.lastIndex])
            return a[0]

        var left = 0
        var right = a.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (a[mid] > target)
                right = mid - 1
            else
                left = mid + 1
        }

        return a[left]
    }
}
