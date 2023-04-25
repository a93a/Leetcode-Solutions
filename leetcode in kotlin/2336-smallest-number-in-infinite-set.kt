class SmallestInfiniteSet() {

    var smallest = 1
    var removed = TreeSet<Int>()

    fun popSmallest(): Int {
        if (removed.isNotEmpty()) {
            return removed.pollFirst()
        } else {
            smallest++
            return smallest - 1
        }
    }

    fun addBack(num: Int) {
        if (smallest > num) removed.add(num)
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
