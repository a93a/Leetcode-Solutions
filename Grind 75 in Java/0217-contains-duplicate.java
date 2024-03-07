// Using java streams
class Solution {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums)
            .distinct()
            .count();
    }
}

// with DIY logic
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
