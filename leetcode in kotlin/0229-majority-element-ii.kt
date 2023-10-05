// solution using hashmap, can easily convert into counting any "k-majority" of input array 
class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        var count = HashMap<Int, Int>()

        for (n in nums) {
            count[n] = count.getOrDefault(n, 0) + 1

            if (count.size <= 2) continue

            var newCount = HashMap<Int, Int>()
            for ((n, c) in count) {
                if (c > 1)
                    newCount[n] = c - 1
            }
            count = newCount
        }

        var res = mutableListOf<Int>()
        
        for ((n, c) in count) {
            var numCount = 0
            for (n2 in nums)
                if (n == n2) 
                    numCount++

            if (numCount > (nums.size / 3)) res.add(n)
        }

        return res
    }
}

// specific for n/3 majority, without hashmap
class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        var count1 = 0
        var count2 = 0
        var num1 = 0
        var num2 = 0

        for (num in nums) {
            if (num == num1) {
                count1++
            } else if (num == num2) {
                count2++
            } else if (count1 == 0) {
                count1 = 1
                num1 = num
            } else if (count2 == 0) {
                count2 = 1
                num2 = num
            } else {
                count1--
                count2--
            }
        }       

        val res = mutableListOf<Int>()
        var numCount1 = 0
        var numCount2 = 0
        for (num in nums) {
            if (num == num1) numCount1++
            if (num == num2) numCount2++
        }

        if (numCount1 > nums.size / 3) res.add(num1)
        if (numCount2 > nums.size / 3 && num1 != num2) res.add(num2)

        return res
    }
}
