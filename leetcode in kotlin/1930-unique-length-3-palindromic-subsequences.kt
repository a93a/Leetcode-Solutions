/*
* Time complexity 0(26*N+N*M) where M is the length of the substring between first and last character ~O(N*M)
* I see many posts claiming O(N) for the time complexity of this algorithm, but for Java/Kotlin, time complexity should be O(M*N)
* since according to https://stackoverflow.com/questions/4679746/time-complexity-of-javas-substring , substring() time complexity is Linear.
*
* Space complexity O(2*26) ~O(1)
*/
class Solution {
    fun countPalindromicSubsequence(s: String): Int {

        val first = IntArray(26) {Integer.MAX_VALUE}
        val second = IntArray(26)
        var res = 0

        for(i in s.indices) {
            first[s[i] - 'a'] = minOf(first[s[i] - 'a'], i)
            second[s[i] - 'a'] = i
        }

        for(i in 0 until 26) {
            if(first[i] < second[i]) 
                res += s.substring(first[i]+1, second[i]).toCharArray().distinct().count()
        }

        return res
    }
}
