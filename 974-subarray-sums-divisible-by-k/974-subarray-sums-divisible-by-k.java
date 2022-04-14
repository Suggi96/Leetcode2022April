class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += ((nums[i]%k) + k)%k;
            count[sum%k]++;
        }
        int ans = count[0];
        for(int c: count) {
            ans += ((c) * (c-1))/2;
        }
        return ans;
    }
}