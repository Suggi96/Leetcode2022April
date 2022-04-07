class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i: stones)
            pq.add(i);
        while(pq.size()>1) {
            int x = pq.remove();
            int y = pq.remove();
            if(x!=y) {
                pq.add(Math.abs(x-y));
            }
        }
        if(pq.size()==1)
            return pq.peek();
        return 0;
    }
}