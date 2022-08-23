class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==536870912) return true;
        double res = Math.log(n)/Math.log(2);
    //    System.out.print(res);
        return res%1==0?true:false;
    }
}