class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        if(digits.length()==0)
            return res;
        backTrack(digits, 0, "", res, mapping);
        return res;        
    }
    private void backTrack(String digits, int idx, String curString, 
                           List<String> res, String[] mapping) {
        if(idx==digits.length()) {
            res.add(curString);
            return;
        }
        String letters = mapping[digits.charAt(idx) - '0'];
        for(int i=0;i<letters.length();i++) {
            backTrack(digits, idx+1, curString + letters.charAt(i), res, mapping);
        }
    }
}