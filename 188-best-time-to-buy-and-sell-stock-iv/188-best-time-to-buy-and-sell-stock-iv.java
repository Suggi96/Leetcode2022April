class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return f(0, 0, prices, n, k, dp);
    }
    private int f(int idx, int transNo, int[] prices, int n, int k, int[][] dp) {
        if(idx>=n || transNo==2*k)
            return 0;
        if(dp[idx][transNo]!=-1)
            return dp[idx][transNo];
        
        if(transNo%2==0) {
            return dp[idx][transNo] = Math.max(-prices[idx] + f(idx+1, transNo+1, prices, n, k, dp),
                                       f(idx+1, transNo, prices, n, k, dp));
        } 
        else {
            return dp[idx][transNo] = Math.max(prices[idx] + f(idx+1, transNo+1, prices, n, k, dp),
                                       f(idx+1, transNo, prices, n, k, dp));
        }
    }
}