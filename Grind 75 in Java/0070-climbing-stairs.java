class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int cur = 0;
        int before = 1;
        int beforeIt = 2;

        for (int i = 2; i < n; i++) {
            cur = before + beforeIt;
            before = beforeIt;
            beforeIt = cur;
        }

        return cur;
    }
}
