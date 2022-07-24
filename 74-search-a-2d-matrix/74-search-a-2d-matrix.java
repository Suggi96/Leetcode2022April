class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0 || n==0)
            return false;
        //search from bottom left cell of matrix
        int i = m-1;
        int j = 0;
        while(i>=0 && j<n) {
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                i--;
            else
                j++;
        }
        return false;
        
    }
}