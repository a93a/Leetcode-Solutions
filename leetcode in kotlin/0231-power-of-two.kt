class Solution {
    fun isPowerOfTwo(n: Int) = (n > 0) && (n and (n - 1) == 0)
}
