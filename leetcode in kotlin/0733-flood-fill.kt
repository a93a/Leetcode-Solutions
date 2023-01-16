class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if(image[sr][sc]==color)
            return image;
        floodFill(image, sr, sc, color, image[sr][sc])
        return image;
    }
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int, oldColor: Int) {
        if(sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size || image[sr][sc]!= oldColor)
            return
        image[sr][sc] = color
        floodFill(image, sr-1, sc, color, oldColor)
        floodFill(image, sr+1, sc, color, oldColor)
        floodFill(image, sr, sc-1, color, oldColor)
        floodFill(image, sr, sc+1, color, oldColor)
    }
}
