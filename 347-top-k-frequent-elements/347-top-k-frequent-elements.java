class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>       
                                                    (map.entrySet());
        Collections.sort(list, (a, b) -> {
           return b.getValue() - a.getValue(); 
        });
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        for(Map.Entry<Integer, Integer> e: list) {
            if(i<k) {
                temp.add(e.getKey());
                i++;
            }
        }
        int[] ans = new int[temp.size()];
        for(i=0;i<temp.size();i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}