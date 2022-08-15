class Solution {
    int count = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] vis = new boolean[n];
        for(int x: restricted)
            vis[x] = true;
        
        dfs(0, vis, graph);
        return count;
        
    }
    private void dfs(int v, boolean[] vis, List<List<Integer>> graph) {
        vis[v] = true;
        count++;
        for(int neigh: graph.get(v)) { 
            if(!vis[neigh]) {
                dfs(neigh, vis, graph);
            }
        }
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