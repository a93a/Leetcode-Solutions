class Solution {
    public void sortColors(int[] n) {
        int l = 0;
        int r = n.length - 1;
        int i = 0;

        while (i <= r) {
            if (n[i] == 0) {
                swap(n, i, l);
                l++;
                i++;
            } else if (n[i] == 1) {
                i++;
            } else {
                swap(n, i, r);
                r--;
            }
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
}
