class Solution {
    fun trap(height: IntArray): Int {
        if(height.size == 0) return 0
        var left = 0; var right = height.size-1
        var maxL = height[left]; var maxR = height[right]
        var sum = 0
        while(left < right){
            if(maxL < maxR){
                left++
                maxL = maxOf(maxL, height[left])
                sum += maxL - height[left]
            }else{
                right--
                maxR = maxOf(maxR, height[right])
                sum += maxR - height[right]
            }
        }
        return sum
    }
}
