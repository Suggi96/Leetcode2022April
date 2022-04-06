class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used);
        return res;
    }
    private void backTrack(int[] nums, List<Integer> permute, boolean[] used) {
        //base case
        if(permute.size()==nums.length) {
            res.add(new ArrayList<>(permute));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]==false) {
                used[i] = true;
                permute.add(nums[i]);
                backTrack(nums, permute, used);
                permute.remove(permute.size()-1);
                used[i] = false;
            }
        }
    }
}