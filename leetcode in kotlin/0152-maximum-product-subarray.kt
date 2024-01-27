class Solution {
    fun maxProduct(n: IntArray): Int {
        var res = n[0]
        var max = n[0]
        var min = n[0]
        
        for (i in 1 until n.size) {
            if (n[i] < 0)
                max = min.also { min = max }
            max = maxOf(n[i], n[i] * max)
            min = minOf(n[i], n[i] * min)
            res = maxOf(res, max)
        }

        return res
    }
}
