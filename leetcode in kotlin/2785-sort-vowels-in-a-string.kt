class Solution {
    fun sortVowels(s: String): String {
        val vowelList = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val vowels = PriorityQueue<Pair<Char, Int>> (compareBy { it.first })

        s.groupingBy { it }
            .eachCount()
            .filter { it.key in vowelList }
            .forEach { vowels.add(it.key to it.value) }

        val res = StringBuilder()
        s.forEach { c ->
            if (vowels.isNotEmpty() && vowels.peek().second == 0)
                vowels.poll()
            
            if (c in vowelList) {
                val (c, count) = vowels.poll()
                res.append(c)
                vowels.add(c to (count - 1))
            } else {
                res.append(c)
            }
        }

        return res.toString()
    }
}
