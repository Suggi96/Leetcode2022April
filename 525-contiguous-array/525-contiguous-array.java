class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); //(prefixSum, idx)
        int ans = 0;
        int prefixSum = 0;
        map.put(prefixSum, -1); //to handle edge case such that if entire array is our                                      ans
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                prefixSum += -1; //converting 0 to -1 and it prefix sum so that
                                 //problem becomes Largest subarray with 0 sum
            }
            else {
                prefixSum += 1; //if nums[i]==1 add it as 1 to prefix sum
            }
            if(map.containsKey(prefixSum)) {
                ans = Math.max(ans, i - map.get(prefixSum));
            }
            else {
                map.put(prefixSum, i); //first time if am seeing prefixSum 
                                        //Then add to map with respective prefixSum,i
            }
        }
        return ans;
        
    }
}