class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0, fresh = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2) {
                    int[] arr = new int[] {i, j};
                    q.add(arr);
                }
            }
        }
        int[][] direction = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while(q.size()!=0 && fresh>0) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                int[] arr = q.remove();
                for(int[] dir: direction) {
                    int row = arr[0] + dir[0];
                    int col = arr[1] + dir[1];
                    if(row<0 || row>=m || col<0 || col>=n || grid[row][col]!=1)
                        continue;
                    grid[row][col] = 2;
                    q.add(new int[] {row, col});
                    fresh--;
                }
            }
            time++;
        }
        if(fresh!=0)
            return -1;
        return time;
    }
}