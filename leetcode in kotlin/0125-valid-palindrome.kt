class Solution {
    fun isPalindrome(s: String): Boolean {
        
        var left = 0; var right = s.length-1
        
        while(left < right){
            while(left < right && !s[right].isPrintAscii())
                right--
            while(left < right && !s[left].isPrintAscii())
                left++
            if(s[left].toLowerCase() != s[right].toLowerCase()){
                return false
            }
            left++
            right--
        }
        return true
    }
    fun Char.isPrintAscii(): Boolean {
        if(this in 'a'..'z' || this in 'A'..'Z' ||this in '0'..'9')
            return true
        else
            return false
    }
}
