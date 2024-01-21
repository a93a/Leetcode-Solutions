class DSU(val n: Int) {

    val parent = IntArray(n) {it}
    val rank = IntArray(n) {1}

    fun find(x: Int): Int {
        if (x != parent[x])
            parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val pX = find(x)
        val pY = find(y)

        if(pX == pY)
            return false
        
        if (rank[pX] > rank[pY]) {
            parent[pY] = pX
            rank[pX] += rank[pY]
        } else {
            parent[pX] = pY
            rank[pY] += rank[pX]
        }

        return true
    }
}