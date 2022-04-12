class Solution {
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        Map<String, Integer> map = new HashMap<>();
        int[][] grid = new int[m][n];
        for(int r=0;r<m;r++) {
            for(int c=0;c<n;c++) {
                int countOne = getCountOne(board, r, c);
                change(board, grid, countOne, r, c);
            }
        }
        //copy grid values into board
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                board[i][j] = grid[i][j];
        return;
    }
    private int getCountOne(int[][] board, int r, int c) {
        int count = 0;
        if(r>=0 && r<board.length && c+1>=0 && c+1<board[0].length) {
            if(board[r][c+1]==1) count++;
        }
        if(r>=0 && r<board.length && c-1>=0 && c-1<board[0].length) {
            if(board[r][c-1]==1) count++;
        }
        if(r-1>=0 && r-1<board.length && c>=0 && c<board[0].length) {
            if(board[r-1][c]==1) count++;
        }
        if(r+1>=0 && r+1<board.length && c>=0 && c<board[0].length) {
            if(board[r+1][c]==1) count++;
        }
        if(r-1>=0 && r-1<board.length && c-1>=0 && c-1<board[0].length) {
            if(board[r-1][c-1]==1) count++;
        }
        if(r-1>=0 && r-1<board.length && c+1>=0 && c+1<board[0].length) {
            if(board[r-1][c+1]==1) count++;
        }
        if(r+1>=0 && r+1<board.length && c-1>=0 && c-1<board[0].length) {
            if(board[r+1][c-1]==1) count++;
        }
        if(r+1>=0 && r+1<board.length && c+1>=0 && c+1<board[0].length) {
            if(board[r+1][c+1]==1) count++;
        }
        return count;
        
    }
    private void change(int[][] board, int[][] grid, int count1, int r, int c) {
        if(board[r][c]==1 && count1<=1) {
            grid[r][c] = 0;
            return;
        }
        else if(board[r][c]==1 && (count1==2 || count1==3)) {
            grid[r][c] = 1;
            return;
        }
        else if(board[r][c]==1 && count1>=4) {
            grid[r][c] = 0;
            return;
        }
        else if(board[r][c]==0 && count1==3) {
            grid[r][c] = 1;
            return;
        }
    }
}