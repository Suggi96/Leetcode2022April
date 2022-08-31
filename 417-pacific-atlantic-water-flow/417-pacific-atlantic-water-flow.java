class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        if(m==0) return ans;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for(int i=0;i<n;i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, m-1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i=0;i<m;i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, n-1, Integer.MIN_VALUE, atlantic);
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(atlantic[i][j]==1 && pacific[i][j]==1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] heights, int i, int j, int prev, int[][] ocean) {
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length)
            return;
        if(ocean[i][j]==1)
            return;
        
        if(heights[i][j]<prev)
            return;
        
        ocean[i][j] = 1;
        dfs(heights, i+1, j, heights[i][j], ocean);
        dfs(heights, i, j+1, heights[i][j], ocean);
        dfs(heights, i-1, j, heights[i][j], ocean);
        dfs(heights, i, j-1, heights[i][j], ocean);
    }
}