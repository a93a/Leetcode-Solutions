class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {    
        val endIndex = cost.size-1
        for(i in 2..endIndex){
           cost[i] += minOf(cost[i-1],cost[i-2])
        }
        return minOf(cost[endIndex], cost[endIndex-1])
    }
}
