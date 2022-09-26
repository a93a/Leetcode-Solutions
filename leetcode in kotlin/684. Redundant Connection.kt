//Could also be solved with dfs/bfs with a time complexity of O(n^2) (E == V)
//However, we will use union+find with path compression to gives us a time complexity of 0(n)...
// ...o(mlogn)
// see https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/UnionFind.pdf
class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        
    val parents = IntArray(edges.size + 1) // 1 to N, we dont use 0
    for(i in 1..parents.size - 1)
        parents[i] = i //each node is its own parent, since this is a undirected graph
    val rank = IntArray(edges.size + 1){ 1 } //all nodes have rank 1 since they are their own parent
    val res = IntArray(2)
    
    for(edge in edges){
        val (node1, node2) = edge
        if(union(node1,node2, parents, rank, res) == false)
            return intArrayOf(node1, node2)
    }
        
    return res
    }
    
    private fun find(
        node: Int, 
        parents: IntArray
    ): Int{
        var parent = parents[node]
        while(parents[parent] != parent){ //until this nodes parent match the nodes parents parent
            parents[parent] = parents[parents[parent]] //path compression
            parent = parents[parent]
        }
        return parent
    }
    
    //modified union which return false on redundant connection
    private fun union(
        node1: Int, 
        node2: Int, 
        parents: IntArray, 
        rank: IntArray, 
        res: IntArray
    ): Boolean{
        val parent1 = find(node1, parents)
        val parent2 = find(node2, parents)
        if(parent1 == parent2){ //redundant connection
            res[0] = node1
            res[1] = node2
            return false
        } 
        if(rank[parent1] > rank[parent2]){
            parents[parent2] = parent1
            rank[parent1] += rank[parent2]
        }else{ // rank[parent1] <= rank[parent2]
            parents[parent1] = parent2
            rank[parent2] += rank[parent1]
        }
        return true
    }
}
