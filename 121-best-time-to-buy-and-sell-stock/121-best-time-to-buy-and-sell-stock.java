class Solution {
    public int maxProfit(int[] prices) {
        int minEl = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++) {
            minEl = Math.min(minEl, prices[i]);
            int curProfit = prices[i] - minEl;
            profit = Math.max(profit, curProfit);
        }
        return profit;
    }
}