class Solution {
    //8 directions with respect to cordinates (0,0)
    private int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, 
                                 {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]==1) {
                    int activeNeigh = getActiveNeigh(board, i, j);
                    if(activeNeigh<2 || activeNeigh>3) 
                        board[i][j] = -2; //intermediate state and also use to count 1s
                }
                else {
                    int activeNeigh = getActiveNeigh(board, i, j);
                    if(activeNeigh==3)
                        board[i][j] = 3;
                }
            }
            
        }
        updateBoard(board);
        return;
    }
        
        private int getActiveNeigh(int[][] board, int i, int j) {
            int activeNeigh = 0;
            for(int[] d: direction) {
                int r = i + d[0];
                int c = j + d[1];
                if(r>=0 && r<board.length && c>=0 && c<board[0].length && 
                  (board[r][c]==1 || board[r][c]==-2))
                    activeNeigh++;
            }
            return activeNeigh;
        }
        
    private void updateBoard(int[][] board) {
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[0].length;j++) {
                    if(board[i][j]==-2)
                        board[i][j]=0;
                    else if(board[i][j]==3)
                        board[i][j] = 1;
                }
            }
        }
}