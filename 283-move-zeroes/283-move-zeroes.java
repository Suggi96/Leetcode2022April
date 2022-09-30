class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1)
            return;
        int left = 0, right = 0;
        while(right<n) {
            if(nums[right]==0)
                right++;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }
}