class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dr = new int[rows];
        int[] dc = new int [cols];
        Arrays.fill(dr, -1);
        Arrays.fill(dc, -1);
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j] == 0) {
                    dr[i] = 0;
                    dc[j] = 0;
                }
            }
        }
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(dr[i]==0 || dc[j]==0)
                    matrix[i][j] = 0;
            }
        }
    }
}