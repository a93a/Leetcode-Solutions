fun main(args: Array<String>) {

    val line = readLine()!!.split(' ').map { it.toInt() }
    val n = line[0]
    val k = line[1]
    val contests = readLine()!!.split(' ').map { it.toInt() }
    val find = Array(k + 1) { mutableListOf<Int>() }

    for ((i, c) in contests.withIndex())
        find[c].add(i)

    val res = LongArray (n) { -1L }
    for (div in k - 1 downTo 1) {
        for (pos in find[div]) {
            if (find[div + 1].last() < pos) {
                res[pos] = n - pos + find[div + 1][0] + res[find[div + 1][0]]
            } else {
                var l = 0
                var r = find[div + 1].lastIndex
                var next = -1
                while (l < r) {
                    val m = l + (r - l) / 2
                    if (find[div + 1][m] > pos) {
                        r = m
                    } else {
                        next = m
                        l = m + 1
                    }
                }
                res[pos] = find[div + 1][r] - pos + res[find[div + 1][r]]
            }
        }
    }

    var min = Long.MAX_VALUE
    for (n in find[1]) {
        min = minOf(min, res[n])
    }
    println(min + 2)
}
