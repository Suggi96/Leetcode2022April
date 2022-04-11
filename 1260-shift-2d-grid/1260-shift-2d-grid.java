class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> oneD = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                oneD.add(grid[i][j]);
            }
        }
            
        //shift each element in oneD list by k positions and save it in             shifted array
        //formula = (index + k) % m*n . here m*n=size of 2d grid
        int[] shifted = new int[m*n]; //creating to prevent overwriting in 
                                      // oneD list 
        for(int i=0;i<oneD.size();i++) {
            int newIndex = (i+k)%(m*n);
            int curVal = oneD.get(i);
            shifted[newIndex] = curVal;
        }

        //Copy 1d array shifted into 2D list res
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int c = 0;
        for(int i=0;i<shifted.length;i++) {
            
            if(c<n) {
                row.add(shifted[i]);
                c++;
            }
            if(c==n) {
                res.add(new ArrayList<>(row));
                c=0;
                row.clear();
            }
        }
        return res;
        
    }
}