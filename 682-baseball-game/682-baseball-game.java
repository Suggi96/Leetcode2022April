class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String s: ops) {
            if(!s.equals("+") && !s.equals("D") && !s.equals("C")) {
                int x = Integer.valueOf(s);
                st.push(x);
            }
            else if(s.equals("+")) {
                int y = st.pop();
                int x = st.pop();
                st.push(x);
                st.push(y);
                st.push(x+y);
            }
            else if(s.equals("D")) {
                int x = st.peek();
                //System.out.print("IN");
                x = 2*x;
                st.push(x);
            }
            else if(s.equals("C")) {
                st.pop();
            }
        }
        int sum = 0;
        for(int i: st) {
            sum += i;
        }
        return sum;
    }
}