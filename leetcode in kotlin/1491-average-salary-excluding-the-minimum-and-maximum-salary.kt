/*
* Using loops directly
*/
class Solution {
    fun average(salary: IntArray): Double {
        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE
        var sum = 0.0
        
        for (n in salary) {
            max = maxOf(max, n)
            min = minOf(min, n)
            sum += n
        }

        return  (sum - max - min) / (salary.size - 2)
    }
}

/*
* Using Kotlins aggregate operations
*/
class Solution {
    fun average(salary: IntArray) = with (salary) {
        (sum() - min()!! - max()!!) / (salary.size - 2).toDouble()
    }
}
