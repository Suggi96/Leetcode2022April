class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int size = num.length();
        if(k==size) return "0";
        int counter = 0;
        while(counter<size) {
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(counter)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(counter));
            counter++;
        }
        //to handle case 11111
        while(k>0) {
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            char c = st.pop();
            ans.append(c);
        }
        ans.reverse();
        //to handle 00012 case ie make it 12 or 000 to 0
        while(ans.length()>1 && ans.charAt(0)=='0') {
            ans.deleteCharAt(0);
        }
        
        return ans.toString();
    }
}