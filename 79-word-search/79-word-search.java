class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j]==word.charAt(0) && dfs(i, j, 0, board, rows, cols, word))
                    return true;
            }
        }
        return false;
    }
    // i -> variable to iterate the word
    private boolean dfs(int r, int c, int idx, char[][] board,
                       int rows, int cols, String word) {
        //base case
        if(idx==word.length())
            return true;
        
        if(r<0 || r>=rows || c<0 || c>=cols 
          || word.charAt(idx)!=board[r][c] || 
          board[r][c]=='*')
        return false;
        
        char temp = board[r][c];
        board[r][c] = '*';
        boolean result = dfs(r, c-1, idx+1, board, rows, cols, word) || 
                 dfs(r, c+1, idx+1, board, rows, cols, word) ||
                 dfs(r-1, c, idx+1, board, rows, cols, word) ||
                 dfs(r+1, c, idx+1, board, rows, cols, word);
        board[r][c] = temp; //backtracing step
        return result;
    }
}