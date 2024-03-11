class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int res = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c))
                left = Math.max(lastSeen.get(c) + 1, left);

            lastSeen.put(c, right);
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
