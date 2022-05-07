class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty() || st.peek().getKey()!=c) {
                st.push(new Pair(c, 1));
            }
            else {
                //matching case
                Pair<Character, Integer> p = st.pop();
                int freq = p.getValue();
                st.push(new Pair(c, freq+1));
                freq = st.peek().getValue();
                if(freq==k) {
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            Pair<Character, Integer> p = st.pop();
            int size = p.getValue();
            while(size-- > 0) {
                sb.append(p.getKey());
            }
        }
       return sb.reverse().toString();
    }
}