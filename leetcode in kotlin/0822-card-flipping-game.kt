// With DIY Logic
class Solution {
    fun flipgame(fronts: IntArray, backs: IntArray): Int {
        val invalid = HashSet<Int>()
        val nums = HashSet<Int>()

        for (i in 0 until fronts.size) {
            if (fronts[i] == backs[i])
                invalid.add(fronts[i])
            nums.add(fronts[i])
            nums.add(backs[i])
        }

        var res = 2001
        for (num in nums) {
            if (num !in invalid) {
                res = minOf(res, num)
            }
        }
        
        return if (res == 2001) 0 else res
    }
}

// With Kotlin functions
class Solution {
    fun flipgame(f: IntArray, b: IntArray) = f
        .zip(b)
        .filter { (x, y) -> x == y }
        .map { it.first }
        .toSet()
        .run {
            (f + b)
            .filter { it !in this }
            .minOrNull() ?: 0
        }
}
