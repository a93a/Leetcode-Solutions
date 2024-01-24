class MKAverage(val m: Int, val k: Int) {
    val indices = FenwickTree (100001)
    val values = FenwickTree (100001)
    val q = LinkedList<Int>()

    fun addElement(num: Int) {
        q.addLast(num)
        indices.update(num, 1)
        values.update(num, num)
        if (q.size > m) {
            val x = q.removeFirst()
            indices.update(x, -1)
            values.update(x, -x)
        }
    }

    fun calculateMKAverage(): Int {
        if (q.size < m)
            return -1

        val l = k
        val r = m - k

        val i = indices.upperBound(l)
        val j = indices.upperBound(r)

        var res = values.range(j) - values.range(i)
        res += (indices.range(i) - l) * i
        res -= (indices.range(j) - r) * j
        return res / (m - 2 * k)
    }
}

class FenwickTree(val size: Int) {
    val nums = IntArray (size + 1)

    fun update(i: Int, v: Int) {
        var i = i
        while (i < size) {
            nums[i] += v
            i += i and -i
        }
    }

    fun range(i: Int): Int {
        var res = 0
        var i = i
        while (i > 0) {
            res += nums[i]
            i -= i and -i
        }
        return res
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
}
