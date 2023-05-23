class Solution {
    fun minJumps(arr: IntArray): Int {
        val adj = HashMap<Int, ArrayList<Int>>()
        for((i,v) in arr.withIndex())
            adj[v] = adj.getOrDefault(v, arrayListOf()).apply { add(i) }
       
        var distance = 0
        with (ArrayDeque<Int>()) {
            add(0)

            while(isNotEmpty()) {
                repeat(size) {
                    val i = poll()
                    
                    if(i == arr.lastIndex)
                        return distance
                    if(i - 1 >= 0 && adj.contains(arr[i - 1]))
                        add(i - 1)
                    if(i + 1 < arr.size && adj.contains(arr[i + 1]))
                        add(i + 1)

                    adj[arr[i]]?.forEach {
                        if(i != it) 
                            add(it)
                    }

                    adj.remove(arr[i])
                }

                distance++ 
            }
        }
        
       return -1
    }
}
