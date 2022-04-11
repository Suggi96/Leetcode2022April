class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
            int m = matrix.length;
            if (m == 0)
                return new int[0];
            int n = matrix[0].length;

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int key = i+j;
                    if(map.containsKey(key)) {
                        List<Integer> al = map.get(key);
                        al.add(matrix[i][j]);
                        map.put(key, al);
                    }
                    else {
                        List<Integer> al = new ArrayList<>();
                        al.add(matrix[i][j]);
                        map.put(key, al);
                    }
                }
            }
        int p = 0;
        int[] ans = new int[m*n];
        //copying hashmap values to ans array
        //also we need reverse the even keys as to print in up direction
        //So call reverse for k = 0 , 2 , 4 etc
        for(int k=0;k<map.size();k++) {
            List<Integer> al = map.get(k);
            if(k%2==0) {
                Collections.reverse(al);
            }
            for(int i: al) {
                ans[p++] = i;
            }
        }
        return ans;
    }
}