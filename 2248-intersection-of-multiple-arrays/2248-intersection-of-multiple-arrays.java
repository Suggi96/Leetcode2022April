class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for(int[] row: nums) {
            for(int i: row) {
                count[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int freq = nums.length;
        for(int i=0;i<count.length;i++) {
            if(count[i]==freq)
                res.add(i);
        }
        return res;
    }
}