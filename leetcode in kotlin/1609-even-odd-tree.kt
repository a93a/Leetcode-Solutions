class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        val q = LinkedList<TreeNode?> ().apply { addLast(root) }
        var isEven = true

        while (q.isNotEmpty()) {
            var prevVal = if (isEven) 0 else 1_000_001

            repeat (q.size) {
                val cur = q.removeFirst()!!

                if (isEven && (cur.`val` % 2 == 0 || cur.`val` <= prevVal))
                    return false
                if (!isEven && (cur.`val` % 2 == 1 || cur.`val` >= prevVal))
                    return false

                prevVal = cur.`val`

                cur.left?.let { q.addLast(it) }
                cur.right?.let { q.addLast(it) }
            }

            isEven = !isEven
        }

        return true
    }
}
