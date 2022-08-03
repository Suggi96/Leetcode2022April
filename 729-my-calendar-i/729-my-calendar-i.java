class MyCalendar {
    private List<int[]> bookings = null;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int s=0, e=bookings.size()-1;
        while (s<=e){
            int mid=s+(e-s)/2;
            int[] bk=bookings.get(mid);
            if (bk[0]==start){
                return false;
            }else if (bk[0]>start){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        if (s>0 && start<bookings.get(s-1)[1])
            return false;

        if (s<bookings.size() && end>bookings.get(s)[0])
            return false;
        
        bookings.add(s, new int[]{start, end});
        return true; 
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */