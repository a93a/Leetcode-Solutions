fun main(args: Array<String>) {

    fun lis(n: Int, nums: List<Int>) {
        val piles = IntArray (n)
        val prev = IntArray (n) { -1 }

        var size = 1
        for (i in 1 until n) {
            if (nums[i] <= nums[piles[0]]) {
                piles[0] = i
            } else if (nums[i] > nums[piles[size - 1]]) {
                prev[i] = piles[size - 1]
                piles[size++] = i
            } else {
                var l = -1
                var r = size - 1
                while (r - l > 1) {
                    val m = l + (r - l) / 2
                    if (nums[piles[m]] >= nums[i]) r = m else l = m
                }
                prev[i] = piles[r - 1]
                piles[r] = i
            }
        }

        println(size)
        val res = mutableListOf<Int>()
        var last = piles[size - 1]
        while (last != -1) {
            res.add(0, last)
            last = prev[last]
        }

        for (i in res.indices) {
            print(res[i])
            if (i < res.lastIndex)
                print(" ")
        }
        println("")
    }

    var line1 = readLine()
    var line2 = readLine()
    while (line1 != null && line2 != null) {
        val n = line1.toInt()
        val nums = line2.split(' ').map { it.toInt() }
        lis(n, nums)
        line1 = readLine()
        line2 = readLine()
    }

}
