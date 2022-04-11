class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int r = 0, c = matrix[0].length-1;
       //starting from top right corner element as pivot
       while(r<matrix.length &&  c>=0) {
           int pivot = matrix[r][c];
           if(target==pivot) 
               return true;
           else if(target<pivot)
               c--;
           else
               r++;
       }
        return false;
    }
}