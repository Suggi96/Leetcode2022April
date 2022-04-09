class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0], nums[1]);
        Set<Integer> set = new HashSet<>();
        for(int i: nums)
            set.add(i);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>            
                                            (Collections.reverseOrder());
        for(int i: set) 
            maxHeap.add(i);
        if(maxHeap.size()<3){
            return maxHeap.peek();
        }
        int ans = 0;
        for(int i=0;i<3;i++) {
            ans = maxHeap.remove();
         //   System.out.println(ans);
        }
        return ans;
    }
}