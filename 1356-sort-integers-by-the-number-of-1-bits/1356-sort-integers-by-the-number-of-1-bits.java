class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        List<Pair<Integer, Integer>> hash = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int count = countSet(arr[i]);
            hash.add(new Pair<Integer, Integer>(arr[i], count));
        }
        Collections.sort(hash, (a, b) -> {
           if(a.getValue()==b.getValue())
               return a.getKey() - b.getKey();
            return a.getValue() - b.getValue();
        });
        int idx = 0;
        for(Pair<Integer, Integer> p: hash) {
            ans[idx++] = p.getKey();
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