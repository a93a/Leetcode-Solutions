// Add all subarray ending at l
class Solution {
    fun countSubarrays(n: IntArray, k: Int): Long {
        val max = n.max()!!
        var l = 0
        var res = 0L
        var count = 0

        for (r in 0 until n.size) {
            if (n[r] == max) count++
            while (count >= k) {
                if (n[l] == max) count--
                l++
            }
            res += l
        }

        return res
    }
}

// count the num of subarrays in left..right with k max elements
class Solution {
    fun countSubarrays(n: IntArray, k: Int): Long {
        val max = n.max()!!
        var l = 0
        var res = 0L
        var indices = mutableListOf(-1)

        for (i in 0 until n.size) {
            if (n[i] == max) indices.add(i)
        }

        for (i in 1 until (indices.size - k + 1)) {
            val start = indices[i] - indices[i - 1]
            val end = n.size - indices[i + k - 1]
            res += start.toLong() * end
        }

        return res
    }
}
