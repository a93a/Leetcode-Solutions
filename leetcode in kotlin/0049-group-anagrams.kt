class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val group = HashMap<String, ArrayList<String>>()

        for (s in strs) {
            val count = IntArray (26)
            for (c in s)
                count[c - 'a']++
            val sb = StringBuilder()
            for (i in 0 until 26) {
                sb.append(count[i])
                sb.append(":")
            }
            val key = sb.toString()
            group[key] = group.getOrDefault(key, ArrayList<String>()).apply { add(s) }
        }

        return ArrayList(group.values)
    }
}
