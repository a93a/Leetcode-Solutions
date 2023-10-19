class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return mutableListOf(1)

        var prev = mutableListOf<Int>()

        for (i in 0 until rowIndex) {
            val new = mutableListOf<Int>()
            new.add(1)
            for (j in 0 until prev.lastIndex) {
                new.add(prev[j]!! + prev[j + 1]!!)
            }
            new.add(1)
            prev = new
        }

        return prev
    }
}
