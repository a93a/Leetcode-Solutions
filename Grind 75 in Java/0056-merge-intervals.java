class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for (int[] itr : intervals) {
            if (res.size() == 0) {
                res.addLast(itr);
            } else {
                int[] prev = res.get(res.size() - 1);
                if (prev[1] >= itr[0]) {
                    res.removeLast();
                    int[] temp = new int[2];
                    temp[0] = Math.min(prev[0], itr[0]);
                    temp[1] = Math.max(prev[1], itr[1]);
                    res.addLast(temp);
                } else {
                    res.addLast(itr);
                }
            }
        }

        int[][] output = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }

        return output;
    }
}
