class Solution {
    fun compress(chars: CharArray): Int {
       var i = 0
       var last = 0
       while (i < chars.size){
           var j = i
           var count = 0
           while(j < chars.size && chars[j] == chars[i]){
               j++
               count++
           }
           chars[last++] = chars[i]//keep the first occurence at its index 
           if(count > 1 && count < 10){
                chars[last++] = '0' + count
           }else if (count == 1) {
               //do nothing
           }else {
               for(c in count.toString()){
                   chars[last++] = c
               }
           } 
           i = j
       }
       return last
    }
}
