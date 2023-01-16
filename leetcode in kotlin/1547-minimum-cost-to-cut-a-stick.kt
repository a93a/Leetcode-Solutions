class Solution {
    
    //time O(n^3) and space O((cuts.size+2)^2)
    fun minCost(n: Int, cuts: IntArray): Int {
        
        val cList = cuts.toCollection(ArrayList())
        cList.add(0)
        cList.add(n)
        cList.sort()
        val dpMemo = Array(cList.size){IntArray(cList.size){-1}}
        
        fun dp(i: Int, j: Int): Int {
            if(j - i <= 1) //size 1 or less
                return 0
            if(dpMemo[i][j] == -1){
                dpMemo[i][j] = Integer.MAX_VALUE
                for(c in i+1 until j){
                    dpMemo[i][j] = minOf(dpMemo[i][j], dp(i, c) + dp(c, j) + (cList[j] - cList[i]))
                }
            }                   
            return dpMemo[i][j]    
        }
    
        return dp(0, cList.size-1)
    }
    
}

/**
class Solution {
    
    //O(cuts.size * n^2) time complexity and O(n^2) space complexity
    // fails the test because of memory usage, cant have O(n^2) space complexity
    fun minCost(n: Int, cuts: IntArray): Int {
        
        // use of memoization to avoid repeated work
        val dpMemo = Array(n+1){IntArray(n+1){-1}} // contains min cost of cutting from i to j
     
        fun dp(left: Int, right: Int): Int {
            
            if(dpMemo[left][right] != -1) // if already in memoization
                return dpMemo[left][right]
                 
            var res = n * n + 1 //Integer.max_value bugs, i choose the largest integer that we cannopt reach,
            // ,even if we have to cut at every index
            var didCut = false // if we cant cut, return 0
            
            for(cut in cuts){
                //if we can cut with this position
                if(cut > left && cut < right){
                    // if we can cut
                    didCut = true
                    // res will be min of:
                    // current min or
                    // min of mincost of (after cutting) left part of log, and right part of log and 
                    // the cut cost of this cut (right - left)
                    res = minOf(res, dp(left, cut) + dp(cut, right) + (right - left))
                }
            }
            
            if(didCut == false){
                dpMemo[left][right] = 0
                return 0
            }
            
            dpMemo[left][right] = res   
            return res
        }
        
        return dp(0, n)
    }
}
**/
