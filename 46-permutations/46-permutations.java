class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used);
        return res;
    }
    private void backTrack(int[] nums, List<Integer> list, boolean[] used) {
        //base case
        if(list.size()==nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]==false) {
                used[i] = true;
                list.add(nums[i]);
                backTrack(nums, list, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}