class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] lastIndex = new int[1000001];
        int minLen = Integer.MAX_VALUE;
        Arrays.fill(lastIndex, -1);
        for(int i=0;i<cards.length;i++) {
            if(lastIndex[cards[i]]!=-1) {
                minLen = Math.min(minLen, i-lastIndex[cards[i]]+1);
            }
            lastIndex[cards[i]] = i;
        }
        return minLen==Integer.MAX_VALUE ? -1 : minLen;
    }
}