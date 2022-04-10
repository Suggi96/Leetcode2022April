class Solution {
    public int largestInteger(int num) {
        String s = num + "";
        //create 2 maxheaps
        PriorityQueue<Integer> odd = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a,b) -> b-a);
        for(char c: s.toCharArray()) {
            int val = c - '0';
            if(val%2==0)
                even.offer(val);
            else
                odd.offer(val);
        }
        String ans = "";
        for(char c: s.toCharArray()) {
            int val = c - '0';
            if(val%2==0)
                ans += even.poll();
            else
                ans += odd.poll();
        }
        return Integer.parseInt(ans);
    }
}