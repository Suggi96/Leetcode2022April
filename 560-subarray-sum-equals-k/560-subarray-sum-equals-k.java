class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum, 1);
        int count = 0;
        for(int i: nums) {
            prefixSum += i;
            if(map.containsKey(prefixSum-k)) {
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}