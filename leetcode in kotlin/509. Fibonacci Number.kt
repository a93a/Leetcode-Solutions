//seems to be the most optimal kotlin specific solution according to leetcode benchmark
//even faster than solution 2 and uses around the same memory
//however in my experience this benchmark is not so accurate, so i dont know for sure
class Solution {
    tailrec fun fib(n: Int): Int {
        if(n <= 1) return n
        return fib(n-1) + fib(n-2)
    }
}

//addition of kotlins tailrec and a mutable map
class Solution {
    val cache = mutableMapOf(0 to 0, 1 to 1)
    tailrec fun fib(n: Int): Int {
        return cache.getOrPut(n) {
            fib(n-1) + fib(n-2)
        }
    }
}

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


class Solution {
    fun fib(n: Int): Int {
        if(n <= 1) return n
        return fib(n-1) + fib(n-2)
    }
}
