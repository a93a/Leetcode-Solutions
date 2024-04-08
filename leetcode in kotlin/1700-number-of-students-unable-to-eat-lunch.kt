class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var zero = 0
        var one = 0
        for (st in students) {
            if (st == 0) zero++
            if (st == 1) one++
        }

        val n = sandwiches.size
        var i = 0
        while (i < n) {
            if (sandwiches[i] == 0 && zero > 0) zero-- 
            else if (sandwiches[i] == 1 && one > 0) one-- 
            else break
            i++
        }

        return n - i
    }
}
