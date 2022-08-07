class Solution {
    public int countVowelPermutation(int n) {
        List<int[]> dp = new ArrayList<>();
        dp.add(new int[] {0,0,0,0,0});
        dp.add(new int[] {1,1,1,1,1});
        int a=0, e=1, i=2, o=3, u=4;
        int mod = (int)(1e9 + 7);
        for(int j=2;j<=n;j++) {
            dp.add(new int[] {0,0,0,0,0});
            dp.get(j)[a] += ((dp.get(j-1)[e] + dp.get(j-1)[i])%mod + dp.get(j-1)[u])%mod;
            dp.get(j)[e] += (dp.get(j-1)[a] + dp.get(j-1)[i])%mod;
            dp.get(j)[i] += (dp.get(j-1)[e] + dp.get(j-1)[o])%mod;
            dp.get(j)[o] += (dp.get(j-1)[i])%mod;
            dp.get(j)[u] += (dp.get(j-1)[i] + dp.get(j-1)[o])%mod;
        }
        int[] arr = dp.get(n);
        int res = 0;
        for(int x: arr) {
            res = (res + x)%mod;
        }
        return res;
    } 
}