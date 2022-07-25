class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, false);
        int last = find(nums, target, true);
        int[] ans = new int[] {first, last};
        return ans;
    }
    private int find(int[] nums, int target, boolean lastOccur) {
        int low = 0, high = nums.length-1;
        int ind = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                ind = mid;
                if(!lastOccur)
                    high = mid - 1; //search in left half because first occur lies in left part                                      
                else
                    low = mid + 1; //search in right half because last occur lies in right part
            }
            else if(nums[mid]>target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ind;
    }

}