class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                pq.add(matrix[i][j]);
            }
        }
        //pop (totalsize-k+1) times as we are using maxheap
        int count = (n*n-k+1);
        System.out.print(count);
        int ans = 0;
        while(count>0) {
            ans = pq.remove();
            count--;
        }
        return ans;
    }
}