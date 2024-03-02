// recursive
class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 1) return true
        if (n <= 0 || n % 2 != 0) return false
        return isPowerOfTwo(n shr 1)
    }
}

// iterative
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        while (n % 2 == 0) {
            n >>= 1;
        }

        return n == 1;
    }
}

// one line bit manipulation
class Solution {
    fun isPowerOfTwo(n: Int) = (n > 0) && (n and (n - 1) == 0)
}
