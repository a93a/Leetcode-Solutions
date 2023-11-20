class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        var res = 0

        "MPG".forEach { type ->
            var cur = 0
            var total = 0
            garbage.withIndex().forEach { (i, block) ->
                if (i > 0)
                    cur += travel[i - 1]
                if (type in block) {
                    cur += block.count { it == type }
                    total = cur
                }
            }
            res += total
        }

        return res
    }
}
