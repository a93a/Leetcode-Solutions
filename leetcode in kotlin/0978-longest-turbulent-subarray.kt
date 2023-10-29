class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        var l = 0
        var r = 1
        var res = 1
        var prev = '$'

        while (r < arr.size) {
            if (arr[r - 1] > arr[r] && prev != '>') {
                res = maxOf(res, r - l + 1)
                r++
                prev = '>'
            } else if (arr[r - 1] < arr[r] && prev != '<') {
                res = maxOf(res, r - l + 1)
                r++
                prev = '<'
            } else {
                if (arr[r - 1] == arr[r]) r = r + 1
                l = r - 1
                prev = '$'
            }
        }

        return res
    }
}
