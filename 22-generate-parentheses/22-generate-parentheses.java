class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }
    private void backTrack(List<String> res, String curString, int open, int close, int max) {
        if(open==max && close==max) {
            res.add(curString);
            return;
        }
        if(open<max) backTrack(res, curString + "(", open+1, close, max);
        if(close<open) backTrack(res, curString + ")", open, close+1, max);
    }
}