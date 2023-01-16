class Solution {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n+1)
        ans[0] == 0
        for(i in 1..n){
            var _i = i
            var count = 0
            while(_i != 0){
                if(_i and 1 == 1) count++
                _i = _i shr 1
            }
            ans[i] = count
        }
        return ans
    }
}
