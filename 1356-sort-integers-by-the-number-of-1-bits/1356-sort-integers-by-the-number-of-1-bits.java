class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int count = countSet(arr[i]);
            map.put(i, count);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            if(a.getValue()==b.getValue())
                return arr[a.getKey()] - arr[b.getKey()];
            return a.getValue() - b.getValue();
        });
        int idx = 0;
        for(Map.Entry<Integer, Integer> e: list) {
            ans[idx++] = arr[e.getKey()];
        }
        return ans;
    }
   private int countSet(int n) {
        int count = 0;
        while(n>0) {
            count += n & 1;
            n = n>>1;
        }
        return count;
    }
}