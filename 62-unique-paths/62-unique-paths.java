class Solution {
    int[][] directions = {{0,1}, {1,0}};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(0, 0, m, n, dp);
    }
    private int dfs(int row, int col, int m, int n,int[][] dp) {
        if(row<0 || row>=m || col<0 || col>=n)
            return 0;
        if(row==m-1 && col==n-1)
            return 1;
        if(dp[row][col]!=0)
            return dp[row][col];
        
        int ans = 0;
        
        for(int[] d: directions) {
            int nrow = row + d[0];
            int ncol = col + d[1];
            ans += dfs(nrow, ncol, m, n, dp);
        }
        dp[row][col] = ans;
        return ans;
    }
}