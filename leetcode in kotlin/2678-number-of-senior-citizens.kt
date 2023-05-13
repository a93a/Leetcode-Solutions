class Solution {
    fun countSeniors(details: Array<String>): Int {
        var res = 0
        
        for (d in details) {
            if (d[11] in '7'..'9') res++
            else if(d[11] == '6' && d[12] != '0') res++
        }
        
        return res
    }
}
