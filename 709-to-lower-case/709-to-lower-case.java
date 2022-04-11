class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            int val = (int)(s.charAt(i));
            if(val>=65 && val<=90) {
                int newVal = val + 32;
                char c = (char)(newVal);
                ans.append(c);
            }
            else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}