class Solution {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 == 1)
            return IntArray(0)

        val count = HashMap<Int, Int>()
        val res = IntArray(changed.size / 2)
        var i = 0

        for (n in changed)
            count[n] = count.getOrDefault(n, 0) + 1

        changed.sort()
        for (n in changed) {
            if (count[n] == 0)
                continue
            if (n == 0 && (count[n * 2]?: 0) % 2 == 1)
                return IntArray(0)
            if ((count[n * 2]?: 0) == 0)
                return IntArray(0)
            count[n] = count.getOrDefault(n, 1) - 1
            count[n * 2] = count.getOrDefault(n * 2, 1) - 1
            res[i++] = n
        }

        return res
    }
}
