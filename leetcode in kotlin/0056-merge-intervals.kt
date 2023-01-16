class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val res = ArrayList<IntArray>()
        intervals.sortBy{it[0]}
        for(interval in intervals){
            if(res.isEmpty()){
                res.add(interval)
            }else if(res.last()[1] < interval[0]){ //no-overlap
                res.add(interval)
            }else{ //overlap
                res.last()[1] = maxOf(res.last()[1], interval[1])
            }
        }
        return res.toTypedArray()
    }
}
