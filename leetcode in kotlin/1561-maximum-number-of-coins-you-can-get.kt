class Solution {
    fun maxCoins(piles: IntArray): Int {
       piles.sort() 
       var res = 0
       val n = piles.size
       for (i in n - 2 downTo (n/3) step 2){
           res += piles[i]
       }
       return res
    }
}

// or more fun with kotlin
class Solution {
    fun maxCoins(piles: IntArray) = piles.sortedDescending()
        .dropLast(piles.size / 3)
        .chunked(2)
        .sumBy { it[1] }
}
