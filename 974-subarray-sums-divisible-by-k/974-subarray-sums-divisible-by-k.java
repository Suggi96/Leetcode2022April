class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum, 1);
        for(int i: nums) {
            sum += i;
            int rem = sum%k;
            if(rem<0) rem = rem + k; //to correct -ve rem ie assume -7%5 = -2 
                                     //but correct ans is -7%5 = -2 + 5 = 3
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}