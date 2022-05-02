class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]%2==0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefSum = 0;
        int count = 0;
        map.put(prefSum, 1);
        for(int i=0;i<n;i++) {
            prefSum += nums[i];
            if(map.containsKey(prefSum-k)) {
                count += map.get(prefSum-k);
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0)+1);
        }
        return count;
    }
}