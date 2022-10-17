/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
//divide and conquer method, merge lists
// time O(NlongK) and space O(1)
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0)
            return null
        var _lists = ArrayList<ListNode?>()
        for(list in lists)
            _lists.add(list)
        while(_lists.size > 1){
            var mergedL = ArrayList<ListNode?>()
            for(i in 0.._lists.size-1 step 2){
                val l1 = _lists.get(i)
                val l2 = if(i+1 < _lists.size) _lists.get(i+1) else null
                val newL = mergeTwoLists(l1, l2)
                mergedL.add(newL)
            }
            _lists = mergedL
        }
        return _lists.get(0)
    }
    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var tail = dummy
        var n1 = list1
        var n2 = list2
        while(n1 != null || n2 != null){  
            if(n1 == null){
                tail?.next = n2
                break
            }
            if(n2 == null){
                tail?.next = n1
                break
            }
            if(n1?.`val` < n2?.`val`){
                tail?.next = n1
                n1 = n1?.next
            }else{
                tail?.next = n2
                n2 = n2?.next
            }
            tail = tail?.next
        }
        return dummy?.next
    }
}


// using minHeap, add K nodes to minHeap and poll
// time O(NlongK) and space O(K)
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0)
            return null
        val minHeap = PriorityQueue<ListNode>{a,b -> a.`val` - b.`val`}
        for(root in lists){
            if(root != null)
                minHeap.add(root)
        }
        val root = ListNode(0)
        var current = root
        while(!minHeap.isEmpty()){
            val nextN = minHeap.poll()
            current.next = nextN
            current = current.next
            val nextNN = current.next
            if(nextNN != null)
                minHeap.add(nextNN)
        }
        return root.next
    }
}

//add all roots to maxHeap, poll one by one and create new list
// time O(NlongN) and space O(N)
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0)
            return null
        val maxHeap = PriorityQueue<ListNode>{a,b -> b.`val` - a.`val`}
        for(root in lists){
            var node = root
            while(node != null){
                val temp = node
                node = node.next
                maxHeap.add(temp)
            }
        }
        var root = maxHeap.poll()
        root?: return null //we had empty only lists
        root.next = null
        while(!maxHeap.isEmpty()){
            val temp = root
            root = maxHeap.poll()
            root.next = temp
        }
        return root
    }
}
