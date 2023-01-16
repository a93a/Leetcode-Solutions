class Solution {
    fun getSum(a: Int, b: Int): Int {
        var carry = b
        var sum = a
        while(carry != 0){
            var temp = (sum and carry) shl 1 // get the carry before changing sum
            sum = sum xor carry 
            carry = temp
        }
        return sum
    }
}
