class Solution {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val m = dungeon.size-1; val n = dungeon[0].size-1      
        dungeon[m][n] = maxOf(1, 1-dungeon[m][n])
        for(i in m-1 downTo 0)
            dungeon[i][n] = maxOf(1, dungeon[i+1][n]-dungeon[i][n])
        for(i in n-1 downTo 0)
            dungeon[m][i] = maxOf(1, dungeon[m][i+1]-dungeon[m][i])
        for(i in m-1 downTo 0){
            for(j in n-1 downTo 0)
                dungeon[i][j] = maxOf(1, minOf(dungeon[i+1][j],dungeon[i][j+1])-dungeon[i][j])
        }
        return dungeon[0][0]
    }
}
