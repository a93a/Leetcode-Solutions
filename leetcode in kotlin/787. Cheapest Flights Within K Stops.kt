class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var costs = IntArray(n)
        Arrays.fill(costs, Integer.MAX_VALUE)
        costs[src] = 0
        //bellman-ford algorithm
        for(i in 0..k){ // we check once for source, and then k times (for each allowed stop) 0 to k = k+1
            val temp = Arrays.copyOf(costs, n) // reason we us temp array, is to only use K allowed "stops"
            for(flight in flights){
                val (from, to, price) = flight
                if (costs[from] == Integer.MAX_VALUE) 
                    continue
                if(costs[from]+price < temp[to])
                    temp[to] = costs[from]+price
            } 
            costs = temp
        }
        return if(costs[dst] != Integer.MAX_VALUE) costs[dst] else -1
    }
}
