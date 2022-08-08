class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            j = 0;
            while(j<i) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(ans, dp[i]);
                }
                j++;
            }
        }
        return ans;
    }
}