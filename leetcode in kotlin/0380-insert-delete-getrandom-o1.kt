// If you are not allowed to use HashSet.random()
class RandomizedSet() {

    val nums = ArrayList<Int>()
    val map = HashMap<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (`val` in map) return false

        nums.add(`val`)
        map[`val`] = nums.lastIndex
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (`val` !in map) return false

        val lastIdx = nums.lastIndex
        val last = nums[lastIdx]
        val removeIdx = map[`val`]!!

        nums[lastIdx] = nums[removeIdx].also { 
            nums[removeIdx] = nums[lastIdx]
        }

        map[last] = removeIdx
        nums.removeLast()
        map.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        val i = (0..nums.lastIndex).random()
        return nums[i]
    }

}

/*
* Containing the logic behind the operations, but a cleaner Kotlin solution is provided below.
* Here implement some of the logic of the functions ourselves, as in the video, to have this solution compatible with the video solution.
*/
class RandomizedSet() {

    val hs = HashSet<Int>()

    fun insert(`val`: Int): Boolean {
        if(hs.contains(`val`)) 
            return false
        else {
            hs.add(`val`)
            return true
        }
    }

    fun remove(`val`: Int): Boolean {
        if(hs.contains(`val`)){
            hs.remove(`val`)
            return true
        }else 
            return false
    }

    fun getRandom(): Int {
        return hs.random()
    }

}
 
/*
* Cleaner Kotlin solution. add() and remove()
*/
class RandomizedSet() {

    val hs = HashSet<Int>()

    fun insert(`val`: Int) = hs.add(`val`)

    fun remove(`val`: Int) = hs.remove(`val`)

    fun getRandom() = hs.random()

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
