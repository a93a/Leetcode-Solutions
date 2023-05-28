class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        var cost = 0
        var min = Integer.MAX_VALUE
        var minIdx = -1
        
        for (i in prices.indices) {
            if (prices[i] < min) {
                min = prices[i]
                minIdx = i
            }
        }
            
            
        cost += min
        
        min = Integer.MAX_VALUE
        for (i in prices.indices) {
            if (prices[i] < min && i != minIdx) {
                min = minOf(min, prices[i])
            }
        }
        
        cost += min
                
        return if (cost <= money) money - cost else money
    }
}
