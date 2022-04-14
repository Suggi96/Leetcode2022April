class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<points.length;i++) {
            int dSquare = (points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            map.put(i, dSquare);
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet())
            list.add(new Pair<Integer, Integer>(e.getKey(), e.getValue()));
        Collections.sort(list, (a, b) -> {
            return a.getValue() - b.getValue();
        });
        int[][] ans = new int[k][2];
        int idx = 0;
        for(Pair<Integer, Integer> p: list) {
            if(k-- > 0) {
                int i = p.getKey();
                ans[idx][0] = points[i][0];
                ans[idx][1] = points[i][1];
                idx++;
            }
        }
        return ans;
    }
}