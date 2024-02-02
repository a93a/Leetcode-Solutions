class Solution {
    fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        val n = nums.size
        val comp = compareBy<Int> { nums[it] }.thenBy { it }
        val s1 = TreeSet (comp)
        val s2 = TreeSet (comp)
        var total = 0L
        var res = Long.MAX_VALUE

        for (j in 1..minOf(dist + 1, n - 1)) {
            total += nums[j]
            s1.add(j)

            if (s1.size > k - 1) {
                val value = s1.pollLast()
                total -= nums[value]
                s2.add(value)
            }
        }
        
        res = minOf(res, total)

        for (j in dist + 2 until n) {
            s2.add(j)

            val i = j - dist - 1

            if (s1.contains(i)) {
                total -= nums[i]
                s1.remove(i)
                
                val si = s2.pollFirst()
                total += nums[si]
                s1.add(si)
            } else {
                s2.remove(i)

                if (nums[s1.last()] > nums[s2.first()]) {
                    val i2 = s1.pollLast()
                    total -= nums[i2]
                    s2.add(i2)

                    val si = s2.pollFirst()
                    total += nums[si]
                    s1.add(si)
                }
            }

            res = minOf(res, total)
        }

        return nums[0] + res
    }
}
