class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] p : pre)
            adj[p[0]].add(p[1]);

        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(i, visit, adj)) return false;
        }
       
        return true;
    }

    private boolean dfs(int i, boolean[] visit, ArrayList<Integer>[] adj) {
        if (visit[i]) return false;
        if (adj[i].isEmpty()) return true;

        visit[i] = true;

        for (int next : adj[i]) {
            if (!dfs(next, visit, adj)) return false;
        }

        visit[i] = false;
        adj[i].clear();
        return true;
    }
}
