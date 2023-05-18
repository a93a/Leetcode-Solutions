class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>) = (0..n - 1) - edges.map { it[1] }
}
