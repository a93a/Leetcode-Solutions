class Solution {
    fun numSimilarGroups(strs: Array<String>): Int {
        val parent = IntArray(strs.size) {it}
        var disJointSets = strs.size

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX != rootY) {
                parent[rootX] = rootY
                disJointSets--
            }
        }

        for (x in strs.indices) {
            for (y in x + 1 until strs.size) {
                if (isSimilar(strs[x], strs[y])) 
                    union(x, y)
            }
        }
        
        return disJointSets--
    }
    
    fun isSimilar(s1: String, s2: String): Boolean {
        var count = 0
        for (i in s1.indices) {
            if (s1[i] != s2[i]) count++
            if (count > 2) break
        }
        return count == 2 || count == 0
    }
}
