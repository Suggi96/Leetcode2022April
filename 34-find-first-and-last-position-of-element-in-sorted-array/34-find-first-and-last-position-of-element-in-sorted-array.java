class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccur(nums, target);
        int last = lastOccur(nums, target);
        int[] ans = new int[] {first, last};
        return ans;
    }
    private int firstOccur(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int ind = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                ind = mid;
                high = mid - 1; //search in left halft because first occur lies in left part
            }
            else if(nums[mid]>target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ind;
    }
        private int lastOccur(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int ind = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                ind = mid;
                low = mid + 1; //search in left halft because first occur lies in left part
            }
            else if(nums[mid]>target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ind;
    }
}