class Solution {
    fun maximumRequests(n: Int, r: Array<IntArray>): Int {
        val degree = IntArray (n)
        var tfrs = 0

        fun dfs(i: Int, curTfrs: Int) {
           if (i == r.size) {
               if (!degree.all {it == 0} ) return
               tfrs = maxOf(tfrs, curTfrs)
               return
            }

            degree[r[i][0]]--
            degree[r[i][1]]++
            dfs(i + 1, curTfrs + 1)

            if (r[i][0] != r[i][1]) {
                degree[r[i][0]]++
                degree[r[i][1]]--
                dfs(i + 1, curTfrs)
            } 
        }

        dfs(0, 0)
        return tfrs
    }
}
