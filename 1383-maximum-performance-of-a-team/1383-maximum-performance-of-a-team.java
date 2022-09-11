class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)(Math.pow(10, 9) + 7);
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new int[] {speed[i], efficiency[i]});
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //sort list in descending order of their efficiency
        Collections.sort(list, (a, b)->b[1]-a[1]);
        long res = 0, Totalspeed = 0;
        for(int i=0;i<n;i++) {
            int curSpeed = list.get(i)[0];
            int curEfficiency = list.get(i)[1];
            if(minHeap.size()==k) {
                Totalspeed -= minHeap.remove();
            }
            Totalspeed += curSpeed;
            minHeap.add(curSpeed);
            res = Math.max(res, curEfficiency*Totalspeed);
        }
        return (int) (res % (long)(1e9 + 7));
    }
}