//without a loop
class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        val temp = ArrayList<Int>()

        fun dfs(i: Int) {
            if (temp.size == k) {
                res.add(ArrayList(temp))
                return
            }
            if (i > n) return

            temp.add(0, i)
            dfs(i + 1)
            temp.removeAt(0)
            dfs(i + 1)
        }
        
        dfs(1)
        return res
    }
}

//with a loop
class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {

        val res = ArrayList<ArrayList<Int>>()

        fun backtrack(start: Int, comb: ArrayList<Int>) {
            if (comb.size == k) {
                res.add(ArrayList(comb))
                return
            }

            for (i in start..n) {
                comb.add(i)
                backtrack(i + 1, comb)
                comb.removeAt(comb.size-1)
            }
        }
        
        backtrack(1, ArrayList<Int>())
        return res
    }
}
