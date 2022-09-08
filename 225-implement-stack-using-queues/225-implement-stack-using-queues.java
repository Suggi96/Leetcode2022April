class MyStack {
    Queue<Integer> q = null;
    int size;
    public MyStack() {
        q = new LinkedList<>();
        size = 0;
    }
    
    public void push(int x) {
        q.add(x);
        size++;
        for(int i=0;i<size-1;i++) {
            q.add(q.peek());
            q.remove();
        }
    }
    
    public int pop() {
        if(size==0) return -1;
        size--;
        return q.remove();
    }
    
    public int top() {
        if(size==0) return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */