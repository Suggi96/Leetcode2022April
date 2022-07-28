class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0;
        int poison = 0;
        for(int n: timeSeries) {
            start = Math.max(start, n);
            poison += duration - (start - n);
            start = n + duration;
        }
        return poison;
    }
}