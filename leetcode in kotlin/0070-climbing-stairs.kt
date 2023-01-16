class Solution {
    fun climbStairs(n: Int): Int {
        var latest = 1; var before = 1
        repeat(n-1){
            val temp = latest
            latest = latest + before
            before = temp
        }
        return latest
    }
}
