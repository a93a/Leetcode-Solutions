// Kotlin way
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val values = arr
            .asIterable()
            .groupingBy { it }
            .eachCount()
            .values
        
        return values.size == values.toSet().size
    }
}

// Count occurences in map and set and check for size equality
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        val set = HashSet<Int>()

        for (a in arr)
            map[a] = (map[a] ?: 0) + 1
        
        for (v in map.values)
            set.add(v)

        return map.size == set.size
    }
}

// Count occurences in map, sort and iterate and check that two consecutive non-zero values are not equal
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = IntArray (2001)    
        for (a in arr)
            map[a + 1000]++
        
        map.sort()
        for (i in 1..2000) {
            if (map[i] > 0 && map[i] == map[i - 1])
                return false
        }

        return true
    }
}
