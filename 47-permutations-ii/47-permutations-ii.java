class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null || nums.length==0)
            return res;
        boolean[] used = new boolean[nums.length]; //used to indicate whether we used a 
        //particular value at that index and to avoid reuse 2nd time
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums); //beneficial to skip duplicate elements while doing recursive                                dfs
        dfs(nums, used, list);
        return res;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> list ) {
        //base case
        if(list.size()==nums.length) {
            //if my current list size is of nums size then i got a valid permutation
            //so add that to res 
            res.add(new ArrayList<>(list));
            return; //i do return because i am done generating valid permutation 
        }
        
        //calling dfs using for loop
        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && used[i-1]==true) continue;
            if(used[i]==false) {
                used[i] = true;
                list.add(nums[i]);
                dfs(nums, used, list);
                list.remove(list.size()-1); //backtracing step
                used[i] = false;
            }
        }
    }
}