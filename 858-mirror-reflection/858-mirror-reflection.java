class Solution {
    public int mirrorReflection(int p, int q) {
        //np - mq = 0
        int n = q/gcd(p,q);
        int m = p/gcd(p,q);
        
        if(n%2==0)
            return 0;
        
        if(n%2==1 && m%2==1) return 1;
        return 2;
    }
    private int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}