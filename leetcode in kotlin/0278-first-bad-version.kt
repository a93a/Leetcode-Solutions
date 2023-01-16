/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1; var right = n
        while(left < right){
            val mid = left + (right - left)/2
            val isBad = isBadVersion(mid)
            if(isBad == true){
                right = mid
            }else{ //isBad == false
                left = mid + 1
            }
        }
        return left
	}
}
