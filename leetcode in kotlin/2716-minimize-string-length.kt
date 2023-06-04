class Solution {
    fun minimizedStringLength(s: String): Int {
        var left = HashMap<Char, Int>()
        var right = HashMap<Char, Int>().apply {
            for (c in s)
                this[c] = getOrDefault(c, 0) + 1
        }

        for (c in s) {
            left[c]?.let { 
                left[c] = left.getOrDefault(c, 1) - 1
            }
            right[c]?.let { 
                right[c] = right.getOrDefault(c, 1) - 1
            }
            left[c] = left.getOrDefault(c, 0) + 1
        }
        
        return left.size
    }
}
