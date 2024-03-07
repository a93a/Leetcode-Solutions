class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (char c : s.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);

        int res = 0;
        for (int value : count.values()) {
            res += (value % 2 == 0) ? value : value - 1;
            if (res % 2 == 0 && value % 2 == 1)
                res++;
        }

        return res;
    }
}
