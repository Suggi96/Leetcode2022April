class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        Arrays.sort(properties, (a, b) -> {
            if(a[0]==b[0])
               return b[1] - a[1];
            else
              return a[0] - b[0];
        });
        int maxDef = Integer.MIN_VALUE;
        int count = 0;
        for(int i=n-1;i>=0;i--) {
            if(properties[i][1]<maxDef) 
                count++;
            if(properties[i][1]>maxDef)
                maxDef = properties[i][1];
        }
        return count;
    }
}