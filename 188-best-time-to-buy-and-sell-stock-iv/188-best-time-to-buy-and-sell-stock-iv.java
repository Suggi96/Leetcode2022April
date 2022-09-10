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
        int ans = 0;
        if(transNo%2==0) {
            int buy = -prices[idx] + f(idx+1, transNo+1, prices, n, k, dp);
            int idle = f(idx+1, transNo, prices, n, k, dp);
            ans = Math.max(buy, idle);
            dp[idx][transNo] = ans;
            return ans;
        } 
        else {
            int sell = prices[idx] + f(idx+1, transNo+1, prices, n, k, dp);
            int idle = f(idx+1, transNo, prices, n, k, dp);
            ans = Math.max(sell, idle);
            dp[idx][transNo] = ans;
            return ans;
        }
    }
}