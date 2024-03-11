// DP
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = m * n;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    if (i > 0)
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if (j > 0) 
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }      
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1)
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                if (j < n - 1) 
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
            }      
        }

        return res;
    }
}

// BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] dirs = new int[]{0, 1, 0, -1, 0};

        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    q.addLast(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
       
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int i = cur[0];
            int j = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k];
                int nj = j + dirs[k + 1];

                if (ni < 0 || nj < 0 || ni == m || nj == n || mat[ni][nj] != -1)
                    continue;
                
                mat[ni][nj] = mat[i][j] + 1;
                q.addLast(new int[]{ni, nj});
            }
        }

        return mat;
    }
}
