class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        build(s, st1);
        build(t, st2);
        StringBuilder ans1 = new StringBuilder();
        StringBuilder ans2 = new StringBuilder();
        for(char c: st1) {
            ans1.append(c);
        }
        for(char c: st2) {
            ans2.append(c);
        }
        return ans1.toString().equals(ans2.toString());
    }
    private void build(String s, Stack<Character> st) {
        for(int i=0;i<s.length();i++) {
            if(st.isEmpty() && s.charAt(i)=='#') 
                continue;
            if(!st.isEmpty() && s.charAt(i)=='#')
                st.pop();
            else
                st.push(s.charAt(i));
        }
    }
}