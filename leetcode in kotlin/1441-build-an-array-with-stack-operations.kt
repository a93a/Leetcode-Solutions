class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        var res = mutableListOf<String>()

        var num = 1
        for (t in target) {
            while (t != num) {
                res.add("Push")
                res.add("Pop")
                num++
            }
            res.add("Push")
            num++
        }

        return res
    }
}
