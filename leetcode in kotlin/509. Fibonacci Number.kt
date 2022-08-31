class Solution {
    fun fib(n: Int): Int {
        if(n <= 1) return n else{
            var r = 0
            var p = 0
            var c = 1
            for(i in 2..n){
                r = c + p
                p = c
                c = r
            }
            return r   
        }
    }
}

/**
class Solution {
    fun fib(n: Int): Int {
        if(n <= 1) return n
        return fib(n-1) + fib(n-2)
    }
}
**/
