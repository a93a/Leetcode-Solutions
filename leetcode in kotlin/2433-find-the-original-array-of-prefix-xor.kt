class Solution {
    fun findArray(pref: IntArray) = pref.apply {
        for (i in pref.lastIndex downTo 1) {
            pref[i] = pref[i] xor pref[i - 1]
        }
    }
}
