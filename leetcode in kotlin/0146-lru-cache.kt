// using HashMap with a doubly linked list
// start of list == LRU
// end of list == MRU
// hashmap wity key -> Node
class LRUCache(val capacity: Int) {
    
    val hm = HashMap<Int, Node>()
    var start = Node(0,0)
    var end = Node(0,0)
    
    init {
        start.next = end
        end.prev = start
    }
    
    //remove from linkedlist
    private fun remove(node: Node?){
        node?: return
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }
    
    //insert at end of linked list (MRU)
    private fun insert(node: Node?){
        node?: return
        val prev = end.prev
        val next = end
        prev?.next = node
        next?.prev = node
        node.next = next
        node.prev = prev
    }
    
    //key value of node if not null, and if not null, update node to MRU
    fun get(key: Int): Int {
        val node = hm.get(key)
        if(node != null){
            remove(node)
            insert(node)
            return node.value
        } 
        return -1
    }

    //Insert node and update MRU
    fun put(key: Int, value: Int) {
        val node = hm.get(key)
        if(node != null)
            remove(node)
        val newNode = Node(key, value)
        hm.put(key, newNode)
        insert(newNode)
        if(hm.size > capacity){
            val lru = start.next
            remove(lru)
            hm.remove(lru!!.key)
        }
    }
    
    data class Node(val key: Int, val value: Int){
        var next: Node? = null
        var prev: Node? = null
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
