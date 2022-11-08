class Solution {
    fun isSameAfterReversals(num: Int): Boolean {
        return if(num==0) true else num%10!=0
    }
}
