class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n:Int):Int {
        var reversed = 0; var _n = n; var count = 0
        repeat(32){
            reversed = reversed shl 1
            reversed = reversed or (_n and 1)
            _n = _n shr 1
        }
        return reversed
    }
}
