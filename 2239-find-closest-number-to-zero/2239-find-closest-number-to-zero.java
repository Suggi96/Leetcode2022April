class Solution {
    public int findClosestNumber(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int ans = 0;
        for(int i: nums) {
            if(Math.abs(i)<mn) {
                mn = Math.abs(i);
                ans = i;
            }
            else if(Math.abs(i)==mn && ans!=i) {
                ans = Math.abs(i);
            }
        }
        return ans;
    }
}