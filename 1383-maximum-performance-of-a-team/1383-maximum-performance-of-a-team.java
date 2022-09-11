class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new int[] {speed[i], efficiency[i]});
        }
        //sort eff in desc order because we need to maximise performance
        // performance =  {sum(speed) * MIN(effi) } -> need max performace upto k selections
        Collections.sort(list, (a, b) -> b[1]-a[1]);
        //used to pop efficiency upto k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long res = 0, tspeed = 0;
        for(int i=0;i<n;i++) {
            int cspeed = list.get(i)[0];
            int ceff = list.get(i)[1];
            if(minHeap.size()==k) {
                tspeed -= minHeap.remove();
            }
            minHeap.add(cspeed);
            tspeed += cspeed;
            res = Math.max(res, tspeed*ceff);
        }
        return (int)(res % (long)(1e9 +7));
    }
}