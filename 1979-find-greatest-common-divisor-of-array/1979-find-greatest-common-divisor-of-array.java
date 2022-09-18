class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int i: nums) {
            small = Math.min(small, i);
            large = Math.max(large, i);
        }
        return gcd(small, large);
    }
    private int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}