class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Long> map = new HashMap<>();
        for(int i: arr)
            map.put(i, map.getOrDefault(i, (long)0)+1);
        long result = 0;
        for(Integer x: map.keySet()) {
            for(Integer y: map.keySet()) {
                int z = target - x - y;
                if(map.containsKey(z)) {
                    long xfreq = map.get(x);
                    long yfreq = map.get(y);
                    long zfreq = map.get(z);
                    if(x==y && y==z) { // all 3 nums are equal
                        result += (xfreq * (xfreq-1) * (xfreq-2))/6;
                    }
                    else if(x==y && y!=z) { //2 nums are equal
                        result += (xfreq * (xfreq-1))/2 * zfreq;
                    }
                    else if(x<y && y<z) { //all 3 nums are not equal
                        result += xfreq * yfreq * zfreq;
                    }
                }
            }
            
        }
        return (int)(result%1000000007);
    }
}