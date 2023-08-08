class Solution {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        
        fun gcd(_a: Int, _b: Int): Int {
            var a = _a
            var b = _b
            while (a != b) {
                if (a > b)
                    a -= b
                else
                    b -= a
            }
            
            return a
        }
        
        var cur = head
        
        while (cur != null && cur.next != null) {
            val common = gcd(cur.`val`, cur.next.`val`)
            val new = ListNode(common)
            
            val temp = cur.next
            cur.next = new
            new.next = temp
            
            cur = cur.next.next
        }
        
        return head
    }
}
