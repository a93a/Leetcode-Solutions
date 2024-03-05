class Solution {
    fun resultArray(nums: IntArray): IntArray {
        val arr1 = mutableListOf<Int> ()
        val arr2 = mutableListOf<Int> ()

        val max = nums.max() ?: 0

        val f1 = FenwickTree (max + 1)
        val f2 = FenwickTree (max + 1)

        arr1.add(nums[0])
        f1.update(nums[0])
        arr2.add(nums[1])
        f2.update(nums[1])

        for (j in 2 until nums.size) {
            val i = nums[j]
            val count1 = f1.range(nums[j] + 1, max)
            val count2 = f2.range(nums[j] + 1, max)

            if (count1 > count2) {
                arr1.add(nums[j])
                f1.update(nums[j])
            } else if (count2 > count1) {
                arr2.add(nums[j])
                f2.update(nums[j])
            } else if (arr1.size > arr2.size) {
                arr2.add(nums[j])
                f2.update(nums[j])
            } else {
                arr1.add(nums[j])
                f1.update(nums[j])
            }
        }

        return (arr1 + arr2).toIntArray()
    }
}

class FenwickTree(val size: Int) {
    val arr = mutableMapOf<Int, Int> ()

    fun range(a: Int, b: Int): Int {
        return range(b) - range(a - 1)
    }

    fun range(i: Int): Int {
        var sum = 0
        var i = i
        
        while (i > 0) {
            sum += arr[i] ?: 0
            i -= i and (-i)
        }

        return sum
    }

    fun update(i: Int) {
        var i = i
        while (i <= size) {
            arr[i] = (arr[i] ?: 0) + 1
            i += i and (-i)
        }
    }
}
