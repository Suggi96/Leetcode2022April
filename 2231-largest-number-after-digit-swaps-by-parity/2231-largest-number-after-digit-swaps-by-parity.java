class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>( (a,b) -> b-a);
        PriorityQueue<Integer> odd = new PriorityQueue<>( (a,b) -> b-a);
        String n = num + "";
        while(num>0) {
            int digit = num % 10;
            if(digit%2==0)
                even.add(digit);
            else
                odd.add(digit);
            num = num / 10;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n.length();i++) {
            int val = Integer.parseInt(n.charAt(i) + "");
            if(val%2==0) {
                res.append(even.remove());
            }
            else {
                res.append(odd.remove());
            }
        }
        return Integer.parseInt(res.toString());
    }
}