class Solution {
    public int arithmeticTriplets(int[] nums, int d) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums)
            set.add(x);
        int count = 0;
        
        for(int x: nums)
            if(set.contains(x-d) && set.contains(x-2*d))
                count++;
        
        return count;
    }
}