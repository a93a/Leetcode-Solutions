class Solution {
    fun smallestSufficientTeam(r: Array<String>, p: List<List<String>>): IntArray {
        val skillMap = HashMap<String, Int>().apply {
            for (i in 0 until r.size) 
                this.put(r[i], i)
        }

        val dp = arrayOfNulls<ArrayList<Int>> (1 shl r.size).apply {
            this[0] = ArrayList<Int>()
        }

        for (i in 0 until p.size) {
            var cur = 0
            for (s in p[i])
                cur = cur or (1 shl skillMap[s]!!)
            for (j in 0 until dp.size) {
                dp[j]?: continue
                val combine = j or cur
                if (dp[combine] == null || dp[j]!!.size + 1 < dp[combine]!!.size) {
                    dp[combine] = ArrayList<Int> (dp[j]).apply { add(i) }
                }
            }
        }

        return dp[(1 shl r.size) - 1]!!.toIntArray()
    }
}
