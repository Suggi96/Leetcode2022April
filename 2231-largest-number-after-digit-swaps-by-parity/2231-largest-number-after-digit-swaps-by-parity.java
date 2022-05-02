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
        String res = new String();
        for(int i=0;i<n.length();i++) {
            int val = Integer.parseInt(n.charAt(i) + "");
            if(val%2==0) {
                res += "" + even.remove();
            }
            else {
                res += "" + odd.remove();
            }
        }
        return Integer.parseInt(res);
    }
}