class Solution {
    public int trap(int[] height) {
       //min(left[i], right[i]) - a[i] = water trapped at ith index
        //left[i] -> maximum height of building from i to 0 (left direction)
        //right[i] -> maximum height of building from i to n-1 (right direction)
        
        int n = height.length;
        int[] prefixMax = new int[n]; //indicates max height from i to 0 (left dir)
        int[] suffixMax = new int[n]; //indicates max hieght from i to n-1 (right dir)
        prefixMax[0] = height[0];
        int maxi = height[0];
        for(int i=1;i<n;i++) {
            maxi = Math.max(maxi, height[i]);
            prefixMax[i] = maxi;
        }
        suffixMax[n-1] = height[n-1];
        maxi = height[n-1];
        for(int i=n-2;i>=0;i--) {
            maxi = Math.max(maxi, height[i]);
            suffixMax[i] = maxi;
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            ans += Math.min(prefixMax[i],suffixMax[i]) - height[i];
        }
        return ans;
    }
}