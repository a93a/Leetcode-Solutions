class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        boolean add = false;

        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (newInterval[1] < interval[0]) { 
                res.add(newInterval);
                add = true;
                break;
            } else if (newInterval[0] > interval[1]) {
                res.add(interval);
            } else { 
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }

            index++;
        }

        if (index < intervals.length) {
            for (int i = index; i < intervals.length; i++)
                res.add(intervals[i]);
        }

        if (!add)
            res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
