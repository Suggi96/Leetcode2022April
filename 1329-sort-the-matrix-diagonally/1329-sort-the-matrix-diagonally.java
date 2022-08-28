class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int key = i-j;
                PriorityQueue<Integer> pq = map.getOrDefault(key, new PriorityQueue<Integer>());
                pq.add(mat[i][j]);
                map.put(key, pq);
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int key = i-j;
                PriorityQueue<Integer> pq = map.get(key);
                mat[i][j] = pq.remove();
            }
        }
        return mat;
    }
}