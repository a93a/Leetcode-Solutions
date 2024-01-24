class FenwickTree(val values: IntArray) {

    val arr = IntArray (values.size + 1)

    fun range(a: Int, b: Int): Int {
        return rangeTo(b) - rangeTo(a - 1)
    }

    init {
        values.forEachIndexed { i, value ->
            update(i + 1, value)
        }
    }

    fun rangeTo(i: Int): Int {
        var sum = 0
        var i = i
        
        while (i > 0) {
            sum += arr[i]
            i -= i and (-i)
        }

        return sum
    }

    fun update(ind: Int, value: Int) {
        var ind = ind
        while (ind < arr.size) {
            arr[ind] += value
            ind += ind and (-ind)
        }
    }

    fun upperBound(v: Int): Int {
        val n = getLog2(size)
        var pos = 0
        var s = 0

        for (i in n downTo 0) {
            if (pos + (1 shl i) < size && s + nums[pos + (1 shl i)] <= v) {
                pos += 1 shl i
                s += nums[pos]
            }
        }
        return pos + 1
    }

    private fun getLog2(x: Int): Int {
        var x = x
        var res = 0
        while (x > 0) {
            res++
            x = x shr 1
        }
        return res
    }
}
