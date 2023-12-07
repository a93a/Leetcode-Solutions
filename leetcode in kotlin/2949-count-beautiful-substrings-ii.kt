class Solution {
    fun beautifulSubstrings(s: String, k: Int): Long {
        var l = 1
        for (i in 1..k) {
            if ((i pow 2) % k == 0) {
                l = i
                break
            }
        }

        var prefix = 0
        var vow = 0
        var res = 0L
        val count = HashMap<Pair<Int, Int>, Int>().apply { this[0 to 0] = 1 }
        for (c in s) {
            if (isVow(c)) {
              prefix++
              vow++
              vow %= l
            } else {
              prefix--
            }
            res = (res + (count[prefix to vow] ?: 0))
            count[prefix to vow] = (count[prefix to vow] ?: 0) + 1
        }

        return res
    }
    
    private fun isVow(c: Char) = c in setOf('a', 'e', 'i', 'o', 'u')

    infix fun Int.pow(k: Int) = Math.pow(this.toDouble(), k.toDouble()).toInt()
}
