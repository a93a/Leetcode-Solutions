class Solution {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        var set = HashSet<Int>()

        for (num in nums) {
            for (n in num[0]..num[1])
                set.add(n)
        }

        return set.size
    }
}
