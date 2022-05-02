class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i: nums) {
            if(i%2==0)
                even.add(i);
            else
                odd.add(i);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int[] res = new int[nums.length];
        int idx = 0;
        for(int i: even) 
            res[idx++] = i;
        for(int i: odd)
            res[idx++] = i;
        return res;
    }
}