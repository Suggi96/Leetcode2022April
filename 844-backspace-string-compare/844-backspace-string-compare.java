class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(st1.empty() && s.charAt(i)=='#') continue;
            if(!st1.empty() && s.charAt(i)=='#')
                st1.pop();
            else
                st1.push(s.charAt(i));
        }
        for(int i=0;i<t.length();i++) {
            if(st2.empty() && t.charAt(i)=='#') continue;
            if(!st2.empty() && t.charAt(i)=='#')
                st2.pop();
            else
                st2.push(t.charAt(i));
        }
        String x = new String();
        String y = new String();
        for(char c: st1) {
         //   System.out.print(c);
             x += c;
        }
           
        for(char c: st2) 
            y += c;
        return x.equals(y);
    }
}