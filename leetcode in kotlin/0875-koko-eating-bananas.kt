class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()!!
        
        fun canEat(k: Int): Boolean {
            var hours = 0L
            for(p in piles) {
                hours += (p / k)
                if(p % k != 0)
                    hours++
            }
            return hours <= h
        }

        while(left <= right) {
            val k = left + (right - left) / 2
            if(canEat(k)){
                right = k - 1
            }else{
                left = k + 1
            }
        }

        return left
    }
}
