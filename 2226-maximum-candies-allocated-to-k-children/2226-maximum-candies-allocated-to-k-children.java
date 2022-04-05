class Solution {
    public int maximumCandies(int[] candies, long k) {
        long ans = 0;
        long low = 1, high = Long.MAX_VALUE;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(possible(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }
    private boolean possible(int[] candies, long k, long x) {
        long count = 0;
        for(int i=0;i<candies.length;i++) {
            count += candies[i]/x;
        }
        if(count>=k)
            return true;
        return false;
    }
}