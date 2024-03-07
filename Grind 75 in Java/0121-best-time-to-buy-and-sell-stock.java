class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int max = 0;

        for (int r = 1; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                max = Math.max(max, profit);
            } else {
                l = r;
            }
        }

        return max;
    }
}
