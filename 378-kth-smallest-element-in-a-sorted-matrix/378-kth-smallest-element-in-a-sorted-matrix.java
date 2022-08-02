class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo<hi) {
            int mid = lo + (hi-lo)/2;
            int count = lessEqual(matrix, mid);
            if(count<k) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
    
    //This returns the exact poisition where target must be present when 2D array is 
    //converted to 1D array linearly sorted. If target is present in matrix it return pos, otherwise      pos+1
    public int lessEqual(int[][] matrix, int target) {
        int count = 0, n = matrix.length;
        int i = n-1, j = 0;
        while(i>=0 && j<n) {
            if(matrix[i][j]>target)
                i--;
            
            else { //matrix[i][j]<=target 
                count = count + i + 1; //0 based indexing so we add +1
                j++;
            } 
        }
        return count;
    }
}