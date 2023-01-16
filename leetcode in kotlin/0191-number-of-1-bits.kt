/*
//For some reason, LeetCode gets an "time exceeded" error on all "unsigned Integers" where
// the mostleft bit (bit #32)is 1, e.g 10000000......0
class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var sum = 0
        var _n = n
        while(_n != 0){
            sum += _n and 1
            _n = _n shr 1
        }
        return sum
    }
}
*/
// Another solution
class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var sum = 0
        var binS = Integer.toBinaryString(n)
        for(c in binS){
            if(c=='1')
                sum++
        }
        return sum
    }
}
