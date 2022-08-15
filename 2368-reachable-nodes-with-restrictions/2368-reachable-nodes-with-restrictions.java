class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] vis = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for(int i: restricted)
            set.add(i);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int curNode = q.remove();
            vis[curNode] = true;
            for(int neigh: graph.get(curNode)) {
                if(!vis[neigh] && !set.contains(neigh)) {
                    q.add(neigh);
                }
            }
        }
        int count = 0;
        for(int i=0;i<vis.length;i++) {
            if(vis[i]) count++;
        }
        return count;
        
    }
    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) 
            g.add(new ArrayList<>());
        
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return g;
    } 
}