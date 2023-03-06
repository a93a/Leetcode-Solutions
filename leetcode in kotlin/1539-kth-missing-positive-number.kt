class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        
        var left = 0
        var right = arr.size
        var mid = 0

        while(left < right) {
            mid = (right + left) / 2
            if(arr[mid] - mid - 1 < k) 
                left = mid + 1
            else 
                right = mid
        }

        return left + k
    }
}
