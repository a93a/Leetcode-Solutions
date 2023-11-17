class Solution {
    fun readBinaryWatch(t: Int): List<String> {
        val res = mutableListOf<String>()

        for (h in 0 until 12) {
            for (m in 0 until 60) {
                if (h.countOneBits() + m.countOneBits() == t)
                    res.add("" + h + ":" + (if (m < 10) "0" else "") + m)
            }
        }

        return res
    }
}
