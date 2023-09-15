class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int) = if (sx == fx && sy == fy) t != 1 
        else maxOf(Math.abs(sx - fx), Math.abs(sy - fy)) <= t
}
