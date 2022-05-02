class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                boolean validSub = compute(nums, i, j, k, p);
                if(validSub) {
                    List<Integer> list = genSub(nums, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private List<Integer> genSub(int[] nums, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for(int i=start;i<=end;i++) {
            list.add(nums[i]);
        }
        return list;
    }
    private boolean compute(int[] nums, int start, int end, int k, int p) {
        int count = 0;
        for(int i=start;i<=end;i++) {
            if(nums[i]%p==0) {
                count++;
            }
        }
        if(count<=k)
            return true;
        return false;
    }
} 