class Solution {
    public int maxSubArray(int[] nums) {
        //kadanes algorithm
        int meh = 0;
        int msf = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            meh = meh + nums[i];
            meh = Math.max(meh, nums[i]);
            msf = Math.max(msf, meh);
        }
        return msf;
    }
}