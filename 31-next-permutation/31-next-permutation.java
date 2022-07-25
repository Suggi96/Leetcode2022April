class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1)
            return;
        
        int pointOfChange = -1;
        for(int i=n-1;i-1>=0;i--) {
            if(nums[i-1]<nums[i]) {
                pointOfChange = i-1;
                break;
            }
        }
        if(pointOfChange==-1) {
            reverse(nums, 0);
            return;
        }
        int swapIndex = -1;
        for(int i=n-1;i>=0;i--) {
            if(nums[i]>nums[pointOfChange]) {
                swapIndex = i;
                break;
            }
        }

        swap(nums, pointOfChange, swapIndex);
        reverse(nums, pointOfChange+1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int ind) {
        int i = ind;
        int j = nums.length-1;
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}