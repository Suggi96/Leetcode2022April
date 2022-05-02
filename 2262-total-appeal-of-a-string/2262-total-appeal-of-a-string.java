class Solution {
    public long appealSum(String s) {
        int n = s.length();
        long res = 0l;
        
        long[] dp = new long[n+1];
        
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        
        for(int i=0;i<n;i++) {
            int c = s.charAt(i) - 'a';
            dp[i+1] = dp[i] + i - lastIndex[c];
            res += dp[i+1];
            
            lastIndex[c] = i;
        }

        return res;
    }
}