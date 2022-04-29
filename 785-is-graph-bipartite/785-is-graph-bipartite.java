class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        Arrays.fill(color, -1);
        for(int i=0;i<len;i++) {
            if(color[i]==-1) {
                color[i] = 0; 
            }
            if(!dfs(i, color, graph)) //process the node at index i
                return false;
        }
        return true;
    }
    private boolean dfs(int index, int[] color, int[][] graph) {
        int currentColor = color[index];
        for(int adjIndex: graph[index]) {
            if(color[adjIndex]==currentColor)
                return false;
            if(color[adjIndex]==-1) {
                int newColor = 1 - currentColor;
                color[adjIndex] = newColor;
                if(!dfs(adjIndex, color, graph)) {
                    return false;
                }
            }
        }
        return true; //happy case
    }
}