// Recursion + Memoization
class Solution {
    private final int MAX_AMOUNT = 100001;
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[MAX_AMOUNT];
        Arrays.fill(dp, -1);
        int res = dfs(amount, coins, dp);
        return res == MAX_AMOUNT ? -1 : res;
    }

    private int dfs(int amount, int[] coins, int[] dp) {
        if (amount < 0) return MAX_AMOUNT;
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];
        

        int res = MAX_AMOUNT;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0)
                res = Math.min(res, 1 + dfs(amount - coins[i], coins, dp));
        }

        dp[amount] = res;
        return res;
    }
}

// DP
class Solution {
    private final int MAX_AMOUNT = 100001;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX_AMOUNT);
        dp[0] = 0;
        
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        return dp[amount] == MAX_AMOUNT ? -1 : dp[amount];
    }
}
