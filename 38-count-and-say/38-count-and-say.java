class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1;i<n;i++) {
            s = countIdx(s);
        }
        return s;
    }
    private String countIdx(String s) {
        char c = s.charAt(0);
        int count = 1;
        StringBuilder res = new StringBuilder();
        for(int i=1;i<s.length();i++) {
            if(c==s.charAt(i)) {
                count++;
            }
            else {
                res.append(count);
                res.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        res.append(count);
        res.append(c);
        return res.toString();
    }
}