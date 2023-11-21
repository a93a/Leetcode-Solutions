class Solution {
    fun maximumXorProduct(a: Long, b: Long, n: Int): Int {
        var ab = a
        var bb = b

        for (bit in n - 1 downTo 0) {
            val mask = 1L shl bit

            if (ab and mask > 0L && bb and mask > 0L)
                continue

            if (ab and mask > 0L) {
                if (ab > bb) {
                    ab = ab xor mask
                    bb = bb or mask
                }
            } else if (bb and mask > 0L) {
                if (ab < bb) {
                    ab = ab or mask
                    bb = bb xor mask
                }
            } else {
                ab = ab or mask
                bb = bb or mask
            }
        }

        return ab.safeMulti(bb)
    }

    fun Long.safeMulti(another: Long): Int {
        val a = BigInteger.valueOf(this)
        val b = BigInteger.valueOf(another)
        val mod = BigInteger.valueOf(1_000_000_007L)
        val res = a.multiply(b).mod(mod)
        return res.toInt()
    }
}
