// Iterative
class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        var res = mutableListOf<Int>()
        var num = 1
        for (i in 1..n) {
            res.add(num)
            if (num * 10 <= n) {
                num *= 10
            } else if (num % 10 != 9 && num + 1 <= n) {
                num++
            } else {
                while ((num / 10) % 10 == 9)
                    num /= 10
                num = num / 10 + 1
            }
        }
        return res
    }
}

// recursive (pre-order traversal)
class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val res = mutableListOf<Int>()

        fun dfs(num: Int) {
            if (num > n) return
            res.add(num)
            for (next in 0..9) {
                if (num * 10 + next > n)
                    return
                dfs(num * 10 + next)
            }
        }

        (1..9).forEach { dfs(it) }

        return res
    }
}
