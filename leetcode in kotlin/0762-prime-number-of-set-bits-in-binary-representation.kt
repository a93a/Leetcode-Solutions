class Solution {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        val prime = setOf(2, 3, 5, 7, 11, 13, 17, 19)

        var res = 0
        (left..right).forEach {
            if (it.bits() in prime) res++
        }

        return res
    }

    fun Int.bits(): Int {
        var x = this
        var res = 0
        while (x > 0) {
            res += x and 1
            x = x shr 1
        }
        return res
    }
}

// or make use of kotlins functions
class Solution {
    val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19)
    
    fun countPrimeSetBits(left: Int, right: Int) = (left..right)
        .map { it.countOneBits() }
        .filter { it in primes }
        .count()
}
