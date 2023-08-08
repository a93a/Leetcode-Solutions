class Solution {
    fun accountBalanceAfterPurchase(p: Int): Int {
        var r = p % 10
        return 100 - if (r >= 5) p - r + 10 else p - r
    }
}
