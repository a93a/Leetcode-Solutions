/*
* Solution as per the channel
*/
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var len = 0
        outerloop@ for(i in 0 until strs[0].length){
            for(s in strs){
                if(i == s.length || s[i] != strs[0][i]){
                    break@outerloop
                }
            }
            len++
        }   
        return strs[0].substring(0,len)
    }
}

/*
* Same solution as above but a little more in an idiomatic Kotlin way
*/
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var res = ""
        strs.minBy { it.length }?.forEachIndexed { i,c ->
            if(strs.all { it[i] == c } ) res += c else return res      
        }
        return res
    }
}
