class Skiplist() {

    var head: SLN? = SLN(-1)

    fun search(target: Int): Boolean {
        var cur = head
        while (cur != null) {
            while (cur?.next != null && cur?.next?.value ?: Integer.MAX_VALUE < target)
                cur = cur.next
            if (cur?.next != null && cur?.next?.value == target)
                return true
            cur = cur?.below
        }
        return false
    }

    fun add(num: Int) {
        val stack = LinkedList<SLN?>()

        var cur = head
        while (cur != null) {
            while (cur?.next != null && cur?.next?.value ?: INF < num)
                cur = cur.next
            stack.addLast(cur)
            cur = cur?.below
        }

        var insert = true
        var below: SLN? = null
        while (insert && stack.isNotEmpty()) {
            cur = stack.removeLast()
            cur?.next = SLN(num, cur?.next, below)
            below = cur?.next
            insert = (Math.random() < 0.5)
        }

        if (insert) head = SLN(-1, null, head)
    }

    fun erase(num: Int): Boolean {
        var cur = head
        var found = false
        while (cur != null) {
            while (cur?.next != null && cur?.next?.value ?: INF < num)
                cur = cur.next
            if (cur?.next != null && cur?.next?.value == num) {
                found = true
                cur.next = cur?.next?.next
            }
            cur = cur?.below
        }
        return found
    }

    class SLN (
        val value: Int,
        var next: SLN? = null,
        val below: SLN? = null,
    )

    companion object {
        const val INF = 20001
    }
}
