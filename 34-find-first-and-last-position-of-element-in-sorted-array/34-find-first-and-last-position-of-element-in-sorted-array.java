class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        if(first==-1)
            return new int[] {-1, -1};
        int last = find(nums, target, false);
        int[] ans = new int[] {first, last};
        return ans;
    }
    private int find(int[] arr, int target, boolean firstOccur) {
        int low = 0, high = arr.length-1;
        int ind = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) {
                ind = mid;
                if(firstOccur==true) 
                    high = mid - 1; //first occur lies in left half
                else
                    low = mid + 1; //;ast occur lies in right half
            }
            else if(arr[mid]>target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ind;
    }

}