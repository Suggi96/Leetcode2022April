class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        int count = 0;
        for(int i: nums) 
            if(i!=0)
                pq.add(i);
        
        while(pq.size()!=0) {
            int top = pq.remove();
            setArray(nums, top, pq);
            count++;
   
        }
        return count;
    }

    private void setArray(int[] nums, int top, PriorityQueue<Integer> pq) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0)
                nums[i] = nums[i] - top;
        }
        pq.clear();
        for(int i: nums)
            if(i!=0)
                pq.add(i);
    }
}