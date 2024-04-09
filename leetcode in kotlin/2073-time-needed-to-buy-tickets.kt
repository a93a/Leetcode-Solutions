class Solution {
    fun timeRequiredToBuy(t: IntArray, k: Int): Int {
        var res = 0
        for (i in t.indices) {
            var cost = minOf(t[i], t[k])
            if (i > k && t[i] >= t[k]) cost--
            res += minOf(t[k], cost)
        }
        return res
    }
}

// or shorter version
class Solution {
    fun timeRequiredToBuy(t: IntArray, k: Int): Int {
        var res = 0
        for (i in t.indices)
            res += minOf(if (i > k) t[k] - 1 else t[k], t[i])
        return res
    }
}

// use fold
class Solution {
    fun timeRequiredToBuy(t: IntArray, k: Int) = t
        .foldIndexed(0) { i, sum, v ->
            sum + minOf(if (i > k) t[k] - 1 else t[k], v)
        }
}

// another cool way I found on LC with sumOf()
class Solution {
    fun timeRequiredToBuy(t: IntArray, k: Int) = t
        .withIndex()
        .sumOf { (i, v) ->
            minOf(if (i > k) t[k] - 1 else t[k], t[i])
        }
}
