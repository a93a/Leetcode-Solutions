class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var res = 0

        for (num in low..high) {
            val s = num.toString()
            var n = s.length
            
            if (n % 2 == 1) continue

            var sum = 0
            for (i in 0 until (n / 2))
                sum += (s[i] - '0') - (s[n - i - 1] - '0')

            if (sum == 0) res++
        }

        return res
    }
}
