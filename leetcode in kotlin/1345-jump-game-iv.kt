class Solution {
    fun minJumps(arr: IntArray): Int {
        val adj = HashMap<Int, ArrayList<Int>>()

        for((i,v) in arr.withIndex()) {
            adj[v] = adj.getOrDefault(v, arrayListOf()).apply{
                this.add(i)
            }
        }
       
        val q = ArrayDeque<Int>()
        q.add(0)
        var distance = 0

        while(q.isNotEmpty()) {
            repeat(q.size) {

                val i = q.poll()
                if(i == arr.lastIndex)
                    return distance

                if(i - 1 >= 0 && adj.contains(arr[i - 1]))
                    q.add(i - 1)

                if(i + 1 < arr.size && adj.contains(arr[i + 1]))
                    q.add(i + 1)

                if(adj.contains(arr[i])) {
                    for(j in adj[arr[i]]!!) {
                        if(i != j) 
                            q.add(j)
                    }
                }
                adj.remove(arr[i])
            }
            distance++ 
        }

       return -1
    }
}
