class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        val combi = ArrayList<Int>()
        dfs(0, target, combi, res, candidates)
        return res
    }
    //fun for backtracking
    private fun dfs(index: Int, target: Int, temp: ArrayList<Int>, res: ArrayList<ArrayList<Int>>, cand: IntArray){
        if(target == 0){
            res.add(ArrayList(temp))
            return
        }
        if(index >= cand.size || target < 0)
            return
        temp.add(cand[index])
        dfs(index, target-cand[index], temp, res, cand)
        temp.removeAt(temp.size-1)
        dfs(index+1, target, temp, res, cand)
    }
}
