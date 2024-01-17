class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val stack = LinkedList<Int>()
        val mod = 1_000_000_007
        var res = 0L
        
        for (right in 0..arr.size) {  
            val curVal = if (right < arr.size) arr[right] else 0
            
            while (stack.isNotEmpty() && curVal < arr[stack.peekLast()]) {
                val cur = stack.removeLast()
                val left = stack.peekLast() ?: -1
                val noOfSubArrs = (cur.toLong() - left) * (right - cur)
                res = (res + noOfSubArrs * arr[cur]) % mod
            }
            
            stack.addLast(right)
        }
        
        return res.toInt()
    }
}
