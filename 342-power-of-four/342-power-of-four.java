class Solution {
    public boolean isPowerOfFour(int n) {
         double res = Math.log(n)/Math.log(4);
        if(res%1==0) return true;
        return false;
    }
}