class Solution {
    fun copyRandomList(node: Node?): Node? {
        val hm = HashMap<Node?, Node?>()

        var old = node
        var dummy: Node? = Node(0)
        var new = dummy

        while (old != null) {
            if (old !in hm)
                hm[old] = Node(old.value)
            
            val next = hm[old]!!
            new?.next = next
            new = new?.next

            val rndm = old.random
            if (rndm != null && rndm !in hm)
                hm[rndm] = Node(rndm.value)
            
            new?.random = hm[rndm] ?: null
            
            old = old?.next
        }

        return dummy?.next
    }

    val Node.value
        get() = this.`val`
}
