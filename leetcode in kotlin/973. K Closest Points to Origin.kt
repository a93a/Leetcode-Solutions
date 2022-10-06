// QuickSelect with average time O(n) and space O(k) since we can return the items IN ANY ORDER, otherwise best is time O(nlogn) and space O(k)
class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        if(points.size == k)
            return points
        val res = Array(k){ IntArray(2) }
        quickSelect(0, points.size-1,points,k)
        for(i in res.indices){
            res[i] = points[i]
        }
        return res
    }
    private fun quickSelect(l: Int, r: Int, points: Array<IntArray>, k: Int){
        var lPointer = l
        for(i in l until r){
            if(distance(i, points) <= distance(r,points)){ //r is pivot
                swap(i,lPointer,points)
                lPointer++
            }
        }
        swap(lPointer,r,points)
        if(lPointer > k)
            quickSelect(l, lPointer-1, points, k)
        else if(lPointer < k)
            quickSelect(lPointer+1, r, points, k)
        else //lPointer == k
            return
    }
    private fun swap(i: Int, j: Int, points: Array<IntArray>){
        val temp = points[i]
        points[i] = points[j]
        points[j] = temp
    }
    private fun distance(i: Int, points: Array<IntArray>) = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1])
}

// time O(nlogn) and space O(k) using maxHeap
class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>{ e1, e2 -> e2[0] - e1[0] }
        val res = Array(k){ IntArray(2) }
        for(point in points){
            val (x,y) = point
            val distance =  (x * x) + (y * y) // we don't need to sqrt since the actual length is of no use
            maxHeap.add(intArrayOf(distance,x,y))
            if(maxHeap.size > k) // keep only the K closest distances
                maxHeap.poll()
        }
        
        for(i in res.indices){
            val (d,x,y) = maxHeap.poll()
            res[i] = intArrayOf(x,y)
        }
        return res
    }
}

// time O(nlogn) and space O(n) using min Heap
class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue<IntArray>{ e1, e2 -> e1[0] - e2[0] }
        val res = Array(k){ IntArray(2) }
        for(point in points){
            val (x,y) = point
            val distance =  (x * x) + (y * y) // we don't need to sqrt since the actual length is of no use
            minHeap.add(intArrayOf(distance,x,y))
        }
        
        for(i in res.indices){
            val (d,x,y) = minHeap.poll()
            res[i] = intArrayOf(x,y)
        }
        return res
    }
}
