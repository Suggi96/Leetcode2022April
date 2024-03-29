class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] counter = count(n);
        for(int i=0;i<31;i++) {
            int num = (int)Math.pow(2, i);
            if(Arrays.equals(counter, count(num)))
                return true;
            
        }
        return false;
    }
    private int[] count(int n) {
        int[] arr = new int[10];
        while(n>0) {
            int rem = n % 10;
            arr[rem]++;
            n /= 10;
        }
        return arr;
    }
}