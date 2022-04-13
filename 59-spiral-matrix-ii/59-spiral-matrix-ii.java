class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int dir = 0, val = 1;
        int[][] grid = new int[n][n];
        while(top<=bottom && left<=right && val<=n*n) {
            if(dir==0) { //left to right using top pointer
               for(int i=left;i<=right;i++) {
                   grid[top][i] = val++;
               } 
                top++;
            }
            else if(dir==1) { //top to bottom using right pointer
                for(int i=top;i<=bottom;i++) {
                   grid[i][right] = val++;
               } 
                right--;
            }
            else if(dir==2) { //right to left using bottom pointer
                for(int i=right;i>=left;i--) {
                   grid[bottom][i] = val++;
               } 
                bottom--;
            }
            else { //bottom to top using left pointer 
                for(int i=bottom;i>=top;i--) {
                   grid[i][left] = val++;
               } 
                left++;
            }
            dir = (dir + 1)%4;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ans[i][j] = grid[i][j];
        return ans;
    }
}