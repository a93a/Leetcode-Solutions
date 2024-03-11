class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return Double.compare(Math.sqrt(a[0] * a[0] + a[1] * a[1]), Math.sqrt(b[0] * b[0] + b[1] * b[1]));
        });

        for (int[] p : points)
            minHeap.add(p);

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = minHeap.poll();
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }

        return res;
    }
}
