class Solution {
    fun maximumStrongPairXor(nums: IntArray) = mutableListOf<Int>().apply {
        nums.forEach { x ->
            nums.forEach { y ->
                if (Math.abs(x - y) <= minOf(x, y))
                    this.add(x xor y)
            }
        }
    }
    .max()
}

// same as above, but let's make it more fun !
class Solution {
    fun maximumStrongPairXor(nums: IntArray) = nums.cartesianProduct()
        .filter(::strongPair)
        .map(::pairXOR)
        .max()

    private fun pairXOR(x: Pair<Int, Int>) = x.first xor x.second

    private fun strongPair(x: Pair<Int, Int>) = Math.abs(x.first - x.second) <= minOf(x.first, x.second)

    fun IntArray.cartesianProduct() = mutableListOf<Pair<Int, Int>>().apply {
        this@cartesianProduct.forEach { x ->
            this@cartesianProduct.forEach { y ->
                this@apply.add(x to y)
            }
        }
    }
}
