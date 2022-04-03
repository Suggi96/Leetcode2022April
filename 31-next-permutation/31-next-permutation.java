class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(nums==null || n<=1) return;
        int i = 0, j=0;
        for( i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1])
                break;
        }
        if(i<0){
           reverse(nums, 0, n-1);
        }
        else {
            for(j=n-1;j>i;j--) {
            if(nums[j]>nums[i])
                break;
        }
            swap(nums, i, j);
            reverse(nums, i+1, n-1);
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}