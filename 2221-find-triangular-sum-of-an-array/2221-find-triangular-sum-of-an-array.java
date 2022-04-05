class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        List<Integer> prev = new ArrayList<>();
        for(int i: nums)
            prev.add(i);
        while(prev.size()!=1) {
            List<Integer> row = new ArrayList<>();
            for(int i=0;i<prev.size()-1;i++) {
                int val = (prev.get(i) + prev.get(i+1)) % 10;
                row.add(val);
            }
            prev = row;
        }
        return (prev.get(0))%10;
    }
}