class Solution {
    public String countAndSay(int n) {
        String val = "1"; //base case
        for(int i=0;i<n-1;i++) {
            char c = val.charAt(0);
            int count = 1;
            StringBuilder s = new StringBuilder();
            for(int j=1;j<val.length();j++) {
                if(c!=val.charAt(j)) {
                    s.append(count);
                    s.append(c);
                    count = 0;
                    c = val.charAt(j);
                }
                count++;
            }
            s.append(count);
            s.append(c);
            val = s.toString();
        }
        return val;
    }
}