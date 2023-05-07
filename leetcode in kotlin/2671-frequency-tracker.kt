class FrequencyTracker() {

    val count = IntArray(100001)
    val freq = IntArray(100001)

    fun add(number: Int) {
        val curFreq = ++count[number]
        freq[curFreq - 1]--
        freq[curFreq]++
    }

    fun deleteOne(number: Int) {
        if (count[number] > 0) {
            val curFreq = --count[number]
            freq[curFreq + 1]--
            freq[curFreq]++
        }
    }

    fun hasFrequency(frequency: Int) = freq[frequency] > 0

}
