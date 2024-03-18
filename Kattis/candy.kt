// Accepted but not optimal solution
fun main(args: Array<String>) {
    val line = readLine()!!.split(' ')
    val n = line[0].toInt()
    val f = line[1].toInt()
    val t = line[2].toLong()
    val candies = readLine()!!.split(' ').map { it.toInt() }

    val dp = HashMap<String, Int> ()
    val MAX = 100000000

    fun dfs(i: Int, boxes: Int, sum: Long): Int {
        dp["${i}:${boxes}:${sum}"]?.let { return it }
        if (boxes == f) {
            return if (sum >= t) 0 else MAX
        }
        if (i == n) return MAX

        var res = MAX
        res = minOf(
            dfs(i + 1, boxes, sum),
            (i - boxes) + dfs(i + 1, boxes + 1, sum + candies[i])
        )

        dp["${i}:${boxes}:${sum}"] = res
        return res
    }

    val res = dfs(0, 0, 0L)
    println(if (res == MAX) "NO" else res)
}
