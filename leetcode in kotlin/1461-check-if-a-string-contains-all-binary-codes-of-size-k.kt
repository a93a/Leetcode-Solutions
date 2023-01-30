class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val hs = HashSet<String>()
        val uniqueBits = Math.pow(2.0, k.toDouble()).toInt()
        for(i in 0..s.lastIndex-k+1) {
            val str = s.substring(i, i + k)
            hs.add(str)
            if(hs.size == uniqueBits) return true
        }
        return false
    }
}
