// For each word, get its sorted counter part. We use "sort by letter" to keep the sort time complexity down to O(n) instead of O(nlogn)
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

// Kotlin idiomatic
class Solution {
    fun groupAnagrams(strs: Array<String>) = strs
    .groupBy { it.groupBy { it } }
    .map { it.value } 
}

// Same as above but instead of groupBy the letters in each word, we use "letter sort" as we did above
// Performs slightly better even though groupBy timecomplexity is also O(n)
class Solution {
    fun groupAnagrams(strs: Array<String>) = strs
    .groupBy { sort(it) }
    .map { it.value } 

    private fun sort(s: String) = buildString {
        val map = IntArray (26)
        for (c in s) map[c - 'a']++
        for (c in 0 until 26) {
            while (map[c] > 0) {
                append(('a' + c).toChar())
                map[c]--
            }
        }
        toString()
    }
}
