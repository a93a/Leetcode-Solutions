class Solution {
    fun minWindow(s: String, t: String): String {

        var start = 0
        var end = 0
        var minStart = 0
        var minLength = Integer.MAX_VALUE
        val map = IntArray(128)
        var count = t.length

        for(c in t)
            map[c.toInt()]++

        while(end < s.length) {
            val endC = s[end].toInt()
            if(map[endC] > 0) count--
            map[endC]--
            end++


            //if we have found all letters, try to minimize the window
            while(count == 0) {
                if((end - start) < minLength){
                    minLength = (end - start)
                    minStart = start
                }

                val startC = s[start].toInt()
                if(map[startC] == 0) count++
                map[startC]++
                start++
            }

        }

        return if(minLength == Integer.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
    }
}
