// Using fenwick tree
class LUPrefix(n: Int) {
    val tree = FenwickTree (IntArray (100001))

    fun upload(video: Int) = tree.upload(video, 1)

    fun longest() = tree.longest()
}
 
class FenwickTree(val values: IntArray) {
    val arr = IntArray (values.size + 1)
    val size = values.size

    fun longest(): Int {
        var l = 0
        var r = 100001
        while (r - l > 1) {
            val m = (l + r) / 2
            if (range(1, m) >= m)
                l = m
            else
                r = m
        }
        return l
    }

    private fun range(a: Int, b: Int): Int {
        return range(b) - range(a - 1)
    }

    private fun range(i: Int): Int {
        var sum = 0
        var i = i
        
        while (i > 0) {
            sum += arr[i]
            i -= i and (-i)
        }

        return sum
    }

    fun upload(ind: Int, value: Int) {
        var ind = ind
        while (ind < arr.size) {
            arr[ind] += value
            ind += ind and (-ind)
        }
    }
}

// Using Union Find
class LUPrefix(val n: Int) {
    val dsu = DSU (n + 1)

    fun upload(v: Int) {
        dsu.add(v)
    }

    fun longest() = dsu.longest()
}

class DSU(val n: Int) {
    val parent = IntArray (n) {it}
    val added = BooleanArray (n)

    fun add(v: Int) {
        added[v] = true
        if (v + 1 < n && added[v + 1])
            union(v, v + 1)
        if (v - 1 >= 0 && added[v - 1])       
            union(v, v - 1)
    }

    fun longest(): Int {
        return if (added[1]) find(1) else 0
    }

    private fun find(x: Int): Int {
        if (x != parent[x])
            parent[x] = find(parent[x])
        return parent[x]
    }

    private fun union(x: Int, y: Int) {
        val pX = find(x)
        val pY = find(y)
        if(pX == pY) return

        if (pX > pY) 
            parent[pY] = pX
        else 
            parent[pX] = pY
    }
}
