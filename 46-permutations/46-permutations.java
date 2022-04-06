class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] freq = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), freq);
        return res;
    }
    private void backTrack(int[] nums, List<Integer> permute, boolean[] freq) {
        //base case
        if(permute.size()==nums.length) {
            res.add(new ArrayList<>(permute));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(freq[i]==false) {
                freq[i] = true;
                permute.add(nums[i]);
                backTrack(nums, permute, freq);
                permute.remove(permute.size()-1);
                freq[i] = false;
            }
        }
    }
}