class Solution {
    fun maxConsecutiveAnswers(a: String, k: Int): Int {
        var res = 0
        var max = 0
        var ts = 0
        var fs = 0

        for (i in 0 until a.length){
            if (a[i] == 'T') max = maxOf(max, ++ts)
            else max = maxOf(max, ++fs)
            if(res - max < k){
                res++
            } else {
                if (a[i - res] == 'T') ts--
                else fs--
            }
        }

        return res
    }
}
