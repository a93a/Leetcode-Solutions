class Solution {
    fun getCommon(n1: IntArray, n2: IntArray): Int {
        var i = 0
        var j = 0
        
        while (i < n1.size && j < n2.size) {
            if (n1[i] == n2[j]) 
                return n1[i]
            else if(n1[i] > n2[j]) 
                j++
            else 
                i++
        }

        return -1
    }
}
