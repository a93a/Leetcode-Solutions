class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val hsA = HashSet<Int>()
        val hsB = HashSet<Int>()
        
        val addedA = HashSet<Int>()
        val addedB = HashSet<Int>()
        
        var res = IntArray(A.size)
        
        for (i in A.indices) {
            val numA = A[i]
            val numB = B[i]
            
            hsA.add(numA)
            hsB.add(numB)
            
            if (i > 0) res[i] += res[i - 1] else res[i] = 0
               
            if (numA in hsB && numA !in addedB) {
                addedA.add(numA)
                res[i] +=1
            }
                
            if (numB in hsA && numB !in addedA) {
                addedB.add(numB)
                res[i] +=1
            }
                
        }
        
        return res
    }
}
