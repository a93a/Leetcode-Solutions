fun main(args: Array<String>) {

    var line = readLine()
    while (line != null && line != "0 0 0") {
        val (n, m, q) = line.split(' ').map { it.toInt() }

        val edges = mutableListOf<IntArray>()
        repeat (m) {
            line = readLine()
            val (u, v, w) = line!!.split(' ').map { it.toInt() }
            edges.add(intArrayOf(u, v, w))
        }

        val queries = mutableListOf<IntArray>()
        repeat (q) {
            line = readLine()
            val (u, v) = line!!.split(' ').map { it.toInt() }
            queries.add(intArrayOf(u, v))
        }

        allPairsShortestPath(n, edges, queries)
        println("")

        line = readLine()
    }

}

fun allPairsShortestPath(n: Int, edges: MutableList<IntArray>, queries: MutableList<IntArray>) {
    val dist = Array (n) { IntArray (n) { Int.MAX_VALUE } }

    for (i in 0 until n) {
        dist[i][i] = 0
    }

    for ((u, v, w) in edges) {
        dist[u][v] = minOf(dist[u][v], w)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE &&
                    dist[i][k] + dist[k][j] < dist[i][j]
                ) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (dist[i][j] != Int.MIN_VALUE && dist[i][k] != Int.MAX_VALUE
                    && dist[k][j] != Int.MAX_VALUE && dist[k][k] < 0
                ) {
                    dist[i][j] = Int.MIN_VALUE
                }
            }
        }
    }

    for ((u, v) in queries) {
        if (dist[u][v] == Int.MAX_VALUE)
            println("Impossible")
        else if (dist[u][v] == Int.MIN_VALUE)
                println("-Infinity")
        else
            println(dist[u][v])
    }
}