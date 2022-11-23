class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.size-1
        
        while(left < right){
            
            val lowest = minOf(height[left], height[right])
            val area = lowest * (right - left)
            max = maxOf(max, area)
            
            if(height[right] > height[left])
                left++
            else
                right--
        }
        
        return max
    }
}
