class SnapshotArray(length: Int) {

    val values = Array (length) { TreeMap<Int, Int>() }
    var snapId = 0

    fun set(index: Int, `val`: Int) {
        values[index].put(snapId, `val`)
    }

    fun snap() = snapId++

    fun get(index: Int, snap_id: Int) = (values[index].floorEntry(snap_id)?.value?: 0)
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = SnapshotArray(length)
 * obj.set(index,`val`)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */
