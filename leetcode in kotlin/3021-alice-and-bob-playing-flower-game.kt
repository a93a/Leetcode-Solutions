class Solution {
    fun flowerGame(n: Int, m: Int): Long {
        val nEven = n.toLong() / 2
        val nOdd = n - nEven
        val mEven = m.toLong() / 2
        val mOdd = m - mEven

        return nEven * mOdd + nOdd * mEven
    }
}
