class Solution {
    int[][] directions = {{0,1}, {1,0}};
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n, new HashMap<String, Integer>());
    }
    private int dfs(int row, int col, int m, int n, HashMap<String, Integer> memo) {
        if(row<0 || row>=m || col<0 || col>=n)
            return 0;
        if(row==m-1 && col==n-1)
            return 1;
        String curKey = row + "-" + col;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int ans = 0;
        
        for(int[] d: directions) {
            int nrow = row + d[0];
            int ncol = col + d[1];
            ans += dfs(nrow, ncol, m, n, memo);
        }
        memo.put(curKey, ans);
        return ans;
    }
}