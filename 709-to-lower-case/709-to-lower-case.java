class Solution {
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++) {
            if('A'<=c[i] && c[i]<='Z') 
                c[i] = (char)(c[i] - 'A' + 'a');
        }
        return new String(c);
    }
}