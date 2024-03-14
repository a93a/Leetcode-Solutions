class Solution {
    int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int numIslands(char[][] g) {
        int res = 0;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j, g);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, char[][] g) {
        g[i][j] = '0';

        for (int d = 0; d < 4; d++) {
            int in = i + dirs[d];
            int jn = j + dirs[d + 1];
            if (in < 0 || jn < 0 || in == g.length || jn == g[0].length || g[in][jn] != '1')
                continue;
            dfs(in, jn, g);
        }
    }
}
