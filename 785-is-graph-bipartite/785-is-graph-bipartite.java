// -1 -> no color , 0-> green, 1 -> red
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length; //no of vertices in graph
        int[] color = new int[len];
        Arrays.fill(color, -1);
        
        for(int i=0;i<len;i++) {
            if(color[i]==-1) {
                color[i] = 1; //color it red
                if(!dfs(i, graph, color)) { //color all adjacent node of i with diff color
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int index, int[][] graph, int[] color) {
        int currentColor = color[index];
        for(int adjIndex: graph[index]) {
            if(color[adjIndex] == currentColor) //adj nodes should not same color
                return false;
            
            if(color[adjIndex]==-1) {
                //if adjNode is uncolored, color it with diff color
                color[adjIndex] = 1 - currentColor;
            
            if(!dfs(adjIndex, graph, color))//recursive dfs might fail when adjnodes have same color
                return false;
            } 
        }
        return true; //happy case
    }
}