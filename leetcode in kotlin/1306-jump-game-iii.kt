class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {

        fun canReach(i: Int): Boolean {
            if (i >= 0 && i <= arr.lastIndex && arr[i] >= 0) {
                if (arr[i] == 0)
                    return true
                arr[i] *= -1
                return canReach(i - arr[i]) || canReach(i + arr[i])       
            }
            return false
        }

        return canReach(start)
    }
}
