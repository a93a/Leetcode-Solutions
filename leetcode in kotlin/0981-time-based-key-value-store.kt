//use hashmap, "key" mapped to treemap of "timestamp, Value"
// timestamps will be in sorted order
// use treeMap.floorkey() to return the greatest key less than or equal to given key from the parameter
// which in our case means, the latest timestamp equal or less than our given timestamp key
// Same time and space complexity as solution below this one
class TimeMap() {
    
    val hm = HashMap<String, TreeMap<Int, String>>()
    
    fun set(key: String, value: String, timestamp: Int) {
        val tm = hm.getOrDefault(key, TreeMap<Int, String>())
        tm.put(timestamp, value)
        hm.put(key, tm)
    }
    
    fun get(key: String, timestamp: Int): String {
        val tm = hm.get(key)
        tm?: return "" // no timestamp in tm that is <= our parameter timestamp
        val ts = tm.floorKey(timestamp)
        return if(ts != null) tm.get(ts)!! else ""
    }
}

// using hashmap to map "key" to list of [value, timestamp]
// and use binary search to find value amoung timestamps
class TimeMap() {
    val hm = HashMap<String, ArrayList<Pair<String, Int>>>()
    fun set(key: String, value: String, timestamp: Int) {
        val list = hm.getOrDefault(key, ArrayList<Pair<String, Int>>())
        list.add(Pair(value,timestamp))
        hm.put(key, list)
    }
    fun get(key: String, timestamp: Int): String {
        val list = hm.get(key)
        list?: return ""
        return binarySearch(timestamp, list)
        
    }
    private fun binarySearch(timestamp: Int, list: List<Pair<String, Int>>): String{
        var left = 0; var right = list.size-1
        var res = ""
        while(left <= right){
            val mid = (left + right) / 2
            if(list.get(mid).second <= timestamp){ // if its a valid value
                res = list.get(mid).first //update with the most recent value so far
                left = mid+1
            }else{ //if mid timestamp is > timestamp
                right = mid - 1
            }
        }
        return res
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
