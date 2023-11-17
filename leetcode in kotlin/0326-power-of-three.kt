// recursion (or can use a loop)
class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n == 1) return true
        if (n <= 0 || n % 3 != 0) return false
        return isPowerOfThree(n / 3)
    }
}

// Clever trick I found in the discussions/solutions forum.
// Highest power of 3 which fits in our constraints (32-bit signed Integer) is 3^19
// If 3^19 mod n == 0 means that n is a power of three
class Solution {
    fun isPowerOfThree(n: Int) = n > 0 && 1162261467 % n == 0
}
