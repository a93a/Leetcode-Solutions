class Solution {
    int[] dir = {0, 1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, image[sr][sc], color, sr, sc);
        return image;
    }

    private void fill(int[][] img, int fromC, int toC, int i, int j) {
        if (i < 0 || j < 0 || i > img.length - 1 || j > img[0].length - 1) return;
        if (img[i][j] != fromC || img[i][j] == toC) return;
        img[i][j] = toC;

        for (int k = 0; k <= 3; k++) {
            fill(img, fromC, toC, i + dir[k], j + dir[k + 1]);
        }
    }
}
