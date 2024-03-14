class Solution {
    public int jobScheduling(int[] s, int[] e, int[] p) {
        int n = s.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int[][] jb = new int[n][3];
        for (int i = 0; i < n; i++) {
            jb[i][0] = s[i];
            jb[i][1] = e[i];
            jb[i][2] = p[i];
        }

        Comparator<int[]> cmp = (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        };

        Arrays.sort(jb, cmp);
        return dfs(jb, 0, dp);
    }

    private int dfs(int[][] jb, int i, int[] dp) {
        if (i == jb.length || i == -1) return 0;
        if (dp[i] != -1) return dp[i];

        int l = i;
        int r = jb.length - 1;
        int j = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (jb[m][0] >= jb[i][1]) {
                j = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int pick = jb[i][2] + dfs(jb, j, dp);
        int notPick = dfs(jb, i + 1, dp);

        dp[i] = Math.max(pick, notPick);
        return dp[i];
    }
}
