// first way
class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var sum = 0
        var max = 0
        for (n in gain) {
            sum += n
            max = maxOf(max, sum)
        }
        return max
    }
}

// second way
class Solution {
    fun largestAltitude(gain: IntArray): Int {
       var res = 0
       gain.fold(0) { acc, n -> (acc + n).apply { res = maxOf(res, this) } }
       return res
    }
}
