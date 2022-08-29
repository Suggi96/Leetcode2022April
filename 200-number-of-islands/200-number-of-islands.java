class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1')
                    res += dfs(i, j, grid, m, n);
            }
        }
        return res;
    }
    private int dfs(int i, int j, char[][] grid, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return 0;
        
        grid[i][j] = '0';
        dfs(i, j+1, grid, m, n);
        dfs(i, j-1, grid, m, n);
        dfs(i-1, j, grid, m, n);
        dfs(i+1, j, grid, m, n);
        return 1;
    }
}