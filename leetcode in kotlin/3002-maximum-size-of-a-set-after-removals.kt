class Solution {
    fun maximumSetSize(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        
        // We need to try to minimize deletion of common element present in both arrays
        // Build sets and find intersection of both sets
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val intrsct = (set1 intersect set2)

        val s1 = set1.size
        val s2 = set2.size
        val i = intrsct.size

        // Max we can take from each array
        // We will try to max out on common elements, but no more than n/2 elements
        val n1 = minOf(n / 2, s1 - i)
        val n2 = minOf(n / 2, s2 - i)
        
        // Max we can take from both arrays, but not more than n elements
        return minOf(n, n1 + n2 + i)
    }
}
