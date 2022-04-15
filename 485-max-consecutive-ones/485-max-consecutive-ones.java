class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                count++;
            //    System.out.println(count);
            }
            else {
                maxi = Math.max(maxi, count);
                count = 0;
            }
            if(i==nums.length-1) {
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}