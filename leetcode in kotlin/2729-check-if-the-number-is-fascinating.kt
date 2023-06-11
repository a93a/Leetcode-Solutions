class Solution {
    fun isFascinating(n: Int): Boolean {
        val set = HashSet<Int>()
        
        fun add(_cur: Int): Boolean {
            var cur = _cur
            while (cur > 0) {
                val n = cur % 10
                if (n == 0 || set.contains(n))
                    return false
                set.add(n)
                cur /= 10
            }
            return true
        }
        
        if (!add(n) || !add(2 * n) || !add(3 * n))
            return false
        return true
    }
}
