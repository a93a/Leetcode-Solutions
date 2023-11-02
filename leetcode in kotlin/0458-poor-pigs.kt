class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        var turns = (minutesToTest / minutesToDie).toDouble()
        var pigs = 0.0
        while (Math.pow(turns + 1, pigs) < buckets) {
            pigs++
        }

        return pigs.toInt()
    }
}
