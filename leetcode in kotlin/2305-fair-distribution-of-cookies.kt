class Solution {
    fun distributeCookies(cookies: IntArray, k: Int): Int {
        val children = IntArray(k)
        var res = Integer.MAX_VALUE

        fun bfs(i: Int) {
            if (i == cookies.size) {
                res = minOf(
                    res,
                    children.max()!!
                )
                return
            }

            for (child in 0 until k) {
                children[child] += cookies[i]
                bfs(i + 1)
                children[child] -= cookies[i]
            }
        }

        bfs(0)
        return res
    }
}
