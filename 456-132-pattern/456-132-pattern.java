class Solution {
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i] < second) 
                return true;
            while(!st.isEmpty() && nums[i] > st.peek()) 
                second = st.pop();
            
            st.push(nums[i]);
        }
        return false;
    }
}