class Solution {
    int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int orangesRotting(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (g[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] cur = q.removeFirst();
                for (int d = 0; d < 4; d++) {
                    int i = cur[0] + dirs[d];
                    int j = cur[1] + dirs[d + 1];
                    if (isValid(g, i, j)) {
                        g[i][j] = 2;
                        q.addLast(new int[]{i, j});
                        fresh--;
                    }
                }                
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }

    private boolean isValid(int[][] g, int i, int j) {
        return i >= 0 && j >= 0 && i < g.length && j < g[0].length && g[i][j] == 1;
    }
}
