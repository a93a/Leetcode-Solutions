class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val end = digits.size-1
        val temp = digits[end] + 1
        if(temp < 10){
            digits[end] = temp
        }else{
            digits[end] = 0
            for(i in end-1 downTo 0){
                val temp = digits[i] + 1
                if(temp < 10){
                    digits[i] = temp
                    break
                }else{
                    digits[i] = 0
                }
            }
            if(digits[0] == 0){
                return intArrayOf(1)+digits
            }
        }   
        return digits
    }
}
