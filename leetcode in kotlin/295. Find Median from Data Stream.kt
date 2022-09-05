class MedianFinder() {
    
    val min = PriorityQueue<Int>{a,b -> a - b}
    val max = PriorityQueue<Int>{a,b -> b - a}

    fun addNum(num: Int) {
        max.add(num)
        // Make sure that biggest in max is smaller than our smallest in min
        if(max.size > 0 && min.size > 0 && max.peek() > min.peek())
            min.add(max.poll())
        //make sure that the difference between min and max is not > 1
        if(max.size - min.size > 1)
            min.add(max.poll())
        if(min.size - max.size > 1)
            max.add(min.poll())
    }

    fun findMedian(): Double {
        if(max.size > min.size)
            return max.peek().toDouble()
        if(min.size > max.size)
            return min.peek().toDouble()
        return (max.peek().toDouble() + min.peek().toDouble()) / 2
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
