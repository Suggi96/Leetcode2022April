class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for(int i: arr) {
// (a%b) = ((a%b) + b)%b this works for both negative and positive numbers. So use it
            int currentRem = ((i%k) + k)%k; 
            freq[currentRem]++;
        }
        for(int i=0;i<=k/2;i++) {
            if(i==0) {
                if(freq[0]%2==1)
                    return false;
            }
            else {
                int y = k-i;
                if(freq[i]!=freq[y])
                    return false;
            }
        }
        return true;
    }
}