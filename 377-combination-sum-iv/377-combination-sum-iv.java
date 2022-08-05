class Solution {
    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target, new HashMap<Integer, Integer>());
    }
    private int helper(int[] nums, int target, Map<Integer, Integer> memo) {
        if(target==0)
            return 1;
        int key = target;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<=target)
            res += helper(nums, target-nums[i], memo);
        }
        memo.put(key, res);
        return res;
    }
}