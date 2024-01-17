class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val stack = LinkedList<Int>().apply { addLast(-1) }
        val mod = 1_000_000_000 + 7
        var res = 0L
        
        for (right in 0..arr.size) {            
            while (stack.peekLast() != -1 && (if (right < arr.size) arr[right] else 0) < arr[stack.peekLast()]) {
                val cur = stack.removeLast()
                val left = stack.peekLast() ?: -1
                res = (res + (cur.toLong() - left) * (right - cur) * arr[cur]) % mod
            }
            
            stack.addLast(right)
        }
        
        return res.toInt()
    }
}
