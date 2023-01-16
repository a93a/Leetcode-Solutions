class Solution {
    fun reverse(x: Int): Int {
        var _x = x; var reversed = 0
        while(_x != 0){
            if(reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10)
                return 0
            reversed = (reversed * 10) + (_x % 10)
            _x = _x / 10
        }
        return reversed
    }
}
