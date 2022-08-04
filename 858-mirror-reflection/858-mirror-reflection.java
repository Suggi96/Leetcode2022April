class Solution {
    public int mirrorReflection(int p, int q) {
        // p * m = q * n
        int m = 1, n = 1;
        while(p*m!=q*n) {
            n = n+1;
            m = (q * n)/p;
        }
        
        if(n%2==0)
            return 2;
        
        else if(m%2==1) //n is definitely odd and m is even
            return 1;
        else            //n is definitely odd and m is odd too
            return 0;
    }
}