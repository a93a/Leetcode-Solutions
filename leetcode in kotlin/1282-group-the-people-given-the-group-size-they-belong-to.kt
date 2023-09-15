class Solution {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val groups = HashMap<Int, MutableList<Int>>()

        for ((people, groupSize) in groupSizes.withIndex()) {
            groups[groupSize] = groups.getOrDefault(groupSize, mutableListOf<Int>()).apply {
                add(people)
            }
        }

        var res = mutableListOf<List<Int>>()
        for ((groupSize, groupList) in groups) {
            groupList.chunked(groupSize).forEach {
                res.add(it)
            }
        } 

        return res
    }
}
