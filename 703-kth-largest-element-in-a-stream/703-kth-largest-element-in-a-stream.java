class KthLargest {
    PriorityQueue<Integer> pq;
    private int n;
    public KthLargest(int k, int[] nums) {
        n = k; //size of pq assigned as n
        pq = new PriorityQueue<>();
        for(int i: nums) {
            add(i);
        }
    } 
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>n) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */