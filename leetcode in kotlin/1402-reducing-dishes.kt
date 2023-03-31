class Solution {

    fun maxSatisfaction(satisfaction: IntArray): Int {

        satisfaction.sort()

        var current = 0

        var res = 0

        for(i in satisfaction.lastIndex downTo 0) {

            current += satisfaction[i]

            if(current < 0 )

                break

            res += current

        }

        return res

    }

}
