class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] shiftedGrid = new int[m][n];
        for(int r=0;r<m;r++) {
            for(int c=0;c<n;c++) {
                int newIdx = ((r*n + c) + k) % (m*n); //mapping 2d index to 1d index                                                        after k shifts
                int newR = newIdx/n; //n is num of cols
                int newC = newIdx%n; //n is num of cols
                shiftedGrid[newR][newC] = grid[r][c]; //save curVal in newR newC idx
            }
        }
       for(int i=0;i<m;i++) {
           List<Integer> temp = new ArrayList<>();
           for(int j=0;j<n;j++) {
            temp.add(shiftedGrid[i][j]);
           }
           ans.add(new ArrayList<>(temp));
    }
         return ans;
    }
}