class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>
                                                   ((a,b) -> b.getValue() - a.getValue());
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.add(new Pair<Integer, Integer>(e.getKey(), e.getValue()));
        }
        int n = arr.length;
     //   List<Integer> list = new ArrayList<>();
        int count = 0, ans = 0;
        while(!pq.isEmpty() && count<n/2) {
            Pair<Integer, Integer> p = pq.remove();
            count += p.getValue();
            ans++;
        }
        return ans;
    }
}