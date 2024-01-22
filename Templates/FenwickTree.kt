class FenwickTree(private val size: Int) {
    val arr = IntArray (size + 1)

    fun range(a: Int, b: Int): Int {
        return rangeTo(b) - rangeTo(a - 1)
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
}
