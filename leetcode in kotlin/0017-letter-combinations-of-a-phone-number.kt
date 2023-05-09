class Solution {
    fun letterCombinations(digits: String): List<String> {
        val res = mutableListOf<String>()
        if (digits == "") return res

        val numToLetter = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz" 
        )

        val temp = CharArray(digits.length)

        fun dfs(i: Int) {
            if (i == digits.length) {
                res.add(temp.joinToString(""))
                return
            }

            numToLetter[digits[i]]?.forEach {
                temp[i] = it
                dfs(i + 1)
            }
        }

        dfs(0)
        return res
    }
}
