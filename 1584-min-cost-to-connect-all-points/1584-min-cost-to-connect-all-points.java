class Solution {
    public int minCostConnectPoints(int[][] points) {
        //minheap to maintain distance from Snode to Nnode
        //PQ<{Snode, Enode, dist}>
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        }); //ascending order priority for distance
        int vertices = points.length;
        int cost = 0;
        HashSet<Integer> visited = new HashSet<>();
        minHeap.add(new int[] {0, 0, 0}); //initially add Snode,Enode and dist as 0 to heap
        while(!minHeap.isEmpty() && visited.size()<vertices) {
            int[] cur = minHeap.poll(); //pops element with least distance
            int Snode = cur[0];
            int Enode = cur[1];
            int dist = cur[2];
            if(visited.contains(Enode)) continue;
            
            cost += dist;
            visited.add(Enode);
            
            for(int i=0;i<vertices;i++) {
                if(!visited.contains(i)) {
                    int curDist = manHattanDist(points, Enode, i);
                    minHeap.add(new int[] {Enode, i, curDist});
                }
            }
            
        }
        return cost;
    }
    private int manHattanDist(int[][] points, int i, int j) {
        int x = Math.abs(points[i][0] - points[j][0]);
        int y = Math.abs(points[i][1] - points[j][1]);
        return x+y;
    }
}