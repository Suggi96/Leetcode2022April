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
        int[] ans = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> e: list) {
            if(i<k) {
                ans[i] = e.getKey();
                i++;
            }
            else
                break;
        }

        return ans;
    }
}