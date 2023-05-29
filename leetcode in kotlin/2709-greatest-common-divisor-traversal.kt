class Solution {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        val parent = IntArray(nums.size) { it }
        val size = IntArray(nums.size) { 1 }
        val found = HashMap<Int, Int>()

        fun find(x: Int): Int {
            if (x != parent[x])
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            if (px != py) {
                if (size[px] > size[py]) {
                    parent[py] = px
                    size[px] += size[py]
                } else {
                    parent[px] = py
                    size[py] += size[px]
                }
            }
        }

        for (i in nums.indices) {
            var p = 2
            var x = nums[i]
            while (p * p <= x) {
                if (x % p == 0) {
                    if (p in found)
                        union(i, found[p]!!)
                    else
                        found[p] = i
                }
                while (x % p == 0)
                    x /= p
                p++
            }
            if (x > 1) {
                if (x in found)
                    union(i, found[x]!!)
                else
                    found[x] = i
            }
        }

        return size[find(0)] == nums.size
    }
}
