class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            st.push(new int[] {val, val});
            return;
        }
        int curEl[] = st.peek();
        if(val < curEl[1]) {
            st.push(new int[] {val, val});
        }
        else {
            st.push(new int[] {val, curEl[1]});
        }
            
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        int[] curEl = st.peek();
        return curEl[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */