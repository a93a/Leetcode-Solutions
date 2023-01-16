class Solution {
    fun letterCasePermutation(s: String): List<String> {
        
        val res = ArrayList<String>()
        var chars = s.toCharArray()
        
        fun permutate(i: Int) {
            if(i == chars.size){
                res.add(String(chars))
                return
            }
            if(!chars[i].isLetter()){
                permutate(i+1)
                return
            }
            chars[i] = chars[i].toLowerCase()
            permutate(i+1)
            chars[i] = chars[i].toUpperCase()
            permutate(i+1)
        }
        
        permutate(0)
        return res
    }
}
