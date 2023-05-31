class Bitset(val size: Int) {

    var one = HashSet<Int>()
    var zero = HashSet<Int>() 
    
    init {
        for (i in 0 until size)
            zero.add(i)
    }

    fun fix(idx: Int) {
        zero.remove(idx)
        one.add(idx)
    }

    fun unfix(idx: Int) {
        one.remove(idx)
        zero.add(idx)
    }

    fun flip() {
        val temp = one
        one = zero
        zero = temp
    }

    fun all(): Boolean {
        return one.size == size
    }

    fun one(): Boolean {
        return one.size > 0
    }

    fun count(): Int {
        return one.size
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (i in 0 until size) {
            if (one.contains(i)) sb.append("1")
            else sb.append("0")
        }
        return sb.toString()
    }

}
