// Sort O(nlogn)
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

// Counting sort O(n)
class Solution {
    fun maxCoins(piles: IntArray): Int {
        val max = piles.max() ?: 10000
        val count = IntArray (max + 1).apply {
            piles.forEach { this[it]++ }
        }

        var res = 0
        var toTake = piles.size / 3
        var aliceTake = true
        var num = max
        while (num > 0) {
            if (count[num] == 0) {
                num--
                continue
            }
            if (toTake == 0) break

            if (!aliceTake) {
                res += num
                toTake--
                aliceTake = true
            } else {
                aliceTake = false
            }

            if (count[num] > 1) {
                count[num]--
            } else {
                num--
            }
        }

        return res
    }
}
