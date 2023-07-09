class Solution {
    fun largestVariance(s: String): Int {
        val chars = s.toSet()

        var res = 0
        for (a in chars) {
            for (b in chars) {
                if (a == b) continue
                var variance = 0
                var bLeft = false
                var firstB = false
                for (c in s) {
                    if (c == a) variance++
                    if (c == b) {
                        bLeft = true
                        if (firstB && variance >= 0)
                            firstB = false
                        else if (--variance < 0) {
                            firstB = true
                            variance = -1
                        }
                    }
                    res = maxOf(
                        res,
                        if (bLeft) variance else 0
                    )
                }
            }
        }

        return res
    }
}
