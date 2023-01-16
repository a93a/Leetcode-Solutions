class Solution {
    fun myAtoi(s: String): Int {
        
        if(s == "") return 0
        
        var i = 0
        var isNegative = false
        var alreadySigned = false
        var res = 0L
        
        while(i < s.length) {
            if(s[i] == ' ')
                i++
            else
                break
        }
        
        while(i < s.length){
            if(s[i] == '+' || s[i] == '-') {
                if(alreadySigned) return 0
                if(s[i] == '-') isNegative = true
                alreadySigned = true
            }else{
                break
            }
            i++
        }
                
        while(i < s.length){
            if(s[i].isDigit()) {
                res *= 10
                res += Character.getNumericValue(s[i])
                if(res !in (Integer.MIN_VALUE..Integer.MAX_VALUE)) break
            }else{
                break
            }
            i++
        }
     
        if(isNegative == true)
            res *= -1
        
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE
        return res.toInt()
    }
}
