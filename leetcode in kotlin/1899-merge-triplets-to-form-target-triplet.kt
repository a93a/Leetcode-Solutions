class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val found = BooleanArray(3)

        for (t in triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue

            for (i in t.indices) {
                if (t[i] == target[i])
                    found[i] = true
            }
        }

        return found.all { it == true }
    }
}
