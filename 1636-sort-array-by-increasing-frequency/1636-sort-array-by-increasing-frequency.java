class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet())
            list.add(new Pair<Integer, Integer>(e.getKey(), e.getValue()));
        Collections.sort(list, (a,b) -> {
            if(a.getValue()==b.getValue())
                return b.getKey() - a.getKey();
            return a.getValue() - b.getValue();
        });
        int idx = 0;
        for(Pair<Integer, Integer> p: list) {
            int freq = p.getValue();
            while(freq!=0) {
                ans[idx++] = p.getKey();
                freq--;
            }
        }
        return ans;
    }
}