class Solution {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var cur = list1
        repeat (a - 1) {
            cur = cur?.next
        }

        var add = cur
        repeat (b - a + 2) {
            cur = cur?.next
        }

        add?.next = list2
        while (add?.next != null)
            add = add?.next
        
        add?.next = cur
        return list1
    }
}
