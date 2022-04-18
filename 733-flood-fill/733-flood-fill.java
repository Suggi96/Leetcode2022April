class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int source = image[sr][sc];
        if(source==newColor) return image;
        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, rows, cols, newColor, source);
        return image;
    }
    private void dfs(int[][] images, int sr, int sc, int rows, int cols,
                    int newColor, int source) {
        if(sr<0 || sc<0 || sr>=rows || sc>=cols)
            return;
        else if(images[sr][sc]!=source)
            return;
        images[sr][sc] = newColor;
        dfs(images, sr-1, sc, rows, cols, newColor, source);
        dfs(images, sr+1, sc, rows, cols, newColor, source);
        dfs(images, sr, sc-1, rows, cols, newColor, source);
        dfs(images, sr, sc+1, rows, cols, newColor, source);
    }
}