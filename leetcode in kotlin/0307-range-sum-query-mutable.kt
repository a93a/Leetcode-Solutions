// Using Fenwick Tree
class NumArray(val nums: IntArray) {

    val n = nums.size
    val tree = FenwickTree (nums)
    
    fun update(index: Int, value: Int) {
        val diff = value - nums[index]
        tree.update(index + 1, diff)
        nums[index] = value
    }

    fun sumRange(left: Int, right: Int): Int {
        return tree.rangeTo(right + 1) - tree.rangeTo(left)
    }
}

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
}

// Using Segment Tree
class NumArray(nums: IntArray) {
    val tree = SegmentTree (nums)

    fun update(index: Int, value: Int) {
       tree.update(index, value) 
    }

    fun sumRange(left: Int, right: Int): Int {
        return tree.rsq(left, right)
    }
}

public class SegmentTree (private val array: IntArray) {

    private var size = (2 * Math.pow(2.0, Math.floor((Math.log(array.size.toDouble()) / Math.log(2.0)) + 1))).toInt()
    private val heap = arrayOfNulls<SegmentNode> (size)

    init {
        build(1, 0, array.size)
    }

    public fun size() = array.size

    private fun build(v: Int, from: Int, size: Int) {
        heap[v] = SegmentNode(
            from = from, 
            to = (from + size - 1)
        )

        if (size == 1) {
            heap[v]?.sum = array[from]
            heap[v]?.min = array[from]
        } else {
            build(2 * v, from, size / 2)
            build(2 * v + 1, from + size / 2, size - size / 2)
            heap[v]?.sum = (heap[2 * v]?.sum ?: 0) + (heap[2 * v + 1]?.sum ?: 0)
            heap[v]?.min = minOf(
                (heap[2 * v]?.min ?: 0), 
                (heap[2 * v + 1]?.min ?: 0)
            )
        }
    }

    public fun rsq(from: Int, to: Int) = rsq(1, from, to)

    private fun rsq(v: Int, from: Int, to: Int): Int {
        val n = heap[v] ?: return 0

        if (n.pendingVal != null && contains(n.from, n.to, from, to))
            return (to - from + 1) * (n.pendingVal ?: 1)

        if (contains(from, to, n.from, n.to))
            return heap[v]?.sum ?: 0

        if (intersects(from, to, n.from, n.to)) {
            propagate(v)
            val leftSum = rsq(2 * v, from, to)
            val rightSum = rsq(2 * v + 1, from, to)

            return leftSum + rightSum
        }

        return 0
    }

    public fun update(atIndex: Int, value: Int) {
        update(1, atIndex, atIndex, value)
    }

    private fun update(v: Int, from: Int, to: Int, value: Int) {
        val n = heap[v] ?: return

        if (contains(from, to, n.from, n.to))
            change(n, value)

        if (n.size() == 1) return

        if (intersects(from, to, n.from, n.to)) {
            propagate(v)

            update(2 * v, from, to, value)
            update(2 * v + 1, from, to, value)

            n.sum = (heap[2 * v]?.sum ?: 0) + (heap[2 * v + 1]?.sum ?: 0)
            n.min = minOf(
                (heap[2 * v]?.min ?: 0), 
                (heap[2 * v + 1]?.min ?: 0)
            )
        }
    }

    private fun propagate(v: Int) {
        val n = heap[v] ?: return

        if (n.pendingVal != null) {
            change(heap[2 * v], n.pendingVal ?: 0)
            change(heap[2 * v + 1], n.pendingVal ?: 0)
            n.pendingVal = null
        }
    }

    private fun change(n: SegmentNode?, value: Int) {
        n ?: return

        n.pendingVal = value
        n.sum = n.size() * value
        n.min = value
        array[n.from] = value

    }

    private fun contains(from1: Int, to1: Int, from2: Int, to2: Int) = from2 >= from1 && to2 <= to1

    private fun intersects(from1: Int, to1: Int, from2: Int, to2: Int) = from1 <= from2 && to1 >= from2
        || from1 >= from2 && from1 <= to2

}

class SegmentNode (
        var sum: Int = 0,
        var min: Int = 0,
        var pendingVal: Int? = null,
        var from: Int,
        var to: Int
) {
    fun size() = to - from + 1
}
