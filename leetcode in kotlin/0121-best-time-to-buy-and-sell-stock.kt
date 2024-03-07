class Solution { 
    fun maxProfit(prices: IntArray): Int {
        var r = 1; var l = 0; var max = 0  
        while (r < prices.size){
            if (prices[l] < prices[r]){
                val profit = prices[r] - prices[l]
                max = maxOf(max, profit)
            }else
                l = r        
            r++
        }
    return max
    }  
}

// Kadane's Algorithm
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var cur = 0
        var maxSoFar = 0

        for (i in 1 until prices.size) {
            cur += prices[i] - prices[i - 1]
            cur = maxOf(0, cur)
            maxSoFar = maxOf(maxSoFar, cur)
        }

        return maxSoFar
    }
}
