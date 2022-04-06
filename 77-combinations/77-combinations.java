class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k, new ArrayList<>());
        return res;
    }
    private void backTrack(int start, int n, int k, List<Integer> combi) {
        if(combi.size()==k) {
            res.add(new ArrayList<>(combi));
            return;
        }
        for(int i=start;i<=n;i++) {
            //choose i
            combi.add(i);
            backTrack(i+1, n, k, combi);
            combi.remove(combi.size()-1); //backtracking step ie delete last element added
        }
    }
}