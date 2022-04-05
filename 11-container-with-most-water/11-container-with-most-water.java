class Solution {
    public int maxArea(int[] height) {
        int maxi = 0;
        int left = 0, right = height.length-1;
        while(left<=right) {
            int l = Math.min(height[left], height[right]);
            int b = right - left;
            maxi = Math.max(maxi, l*b);
            if(height[left]<height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxi;
    }
}