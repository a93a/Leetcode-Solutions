//faster solution using KMP style LPS
// huge difference in leetcode runtime and space 
class Solution {
    fun shortestPalindrome(s: String): String {
        var rev = s.reversed()
        var kmpS = s + "." + rev // "." as delimiter diving the string
        var lps = IntArray(kmpS.length)
        for(i in 1 until kmpS.length){
            var j = lps[i-1]
            while(j > 0 && kmpS[i] != kmpS[j])
                j = lps[j - 1]
            if(kmpS[i] == kmpS[j])
                j++
            lps[i] = j
        }
        return rev.substring(0, (s.length - lps[kmpS.length - 1])) + s
    }
}


// pointer solutin
class Solution {
    fun shortestPalindrome(s: String): String {
        var end = s.length-1
        var start = 0
        
        //find the longest palindrom starting from index 0
        while(start <= end){
            
            var left = start
            var right = end
            
            while(left <= right){
                if(s[left] != s[right]) break //not a valid palindrom
                left++
                right--
            }
            
            if(left > right)break //pointers crossed, we found longest palindrom ending at index "end"
            end--   
        }
         
        // palindrom was whole string?
        if(end == s.length-1) return s
        
        var res = s
        for(i in end+1 until s.length)
            res = s[i] + res
                
        return res
    }
}
