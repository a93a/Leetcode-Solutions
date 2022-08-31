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
