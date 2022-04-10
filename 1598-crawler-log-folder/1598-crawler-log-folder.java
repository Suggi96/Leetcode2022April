class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for(String s: logs) {
            if(!st.empty() && s.equals("../")) {
                st.pop();
            }
            else if(s.equals("./")){
                continue;
            }
            else {
                if(!s.equals("./") && !s.equals("../"))
                st.push(s);
            }
        }
        return st.size();
    }
}