class Solution {
    public int maximumProduct(int[] nums, int k) {
        //create minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums)
            pq.add(i);
        while(k!=0) {
            int x = pq.poll();
            pq.offer(x+1);
            k--;
        }
        int mod = (int)(Math.pow(10,9)+7);
        long res = 1;
        while(!pq.isEmpty()) {
            int top = pq.remove();
            res = (res%mod * top%mod)%mod;
        }
        return (int)res%mod;
    }
}