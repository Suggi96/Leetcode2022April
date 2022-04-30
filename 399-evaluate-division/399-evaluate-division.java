class Solution {
    public class Node  {
        String key;
        double val;
        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g);
        }
        return res;
    }
    private double dfs(String s, String d, Set<String> visited,  Map<String, List<Node>> g) {
        if( !(g.containsKey(s) && g.containsKey(d)) ) //invalid case when any s node or d node not in g
           return -1.0;
        
        if(s.equals(d)) //base case when s node is same as d node
            return 1.0;
        
        visited.add(s);
        for(Node ng: g.get(s)) {
            if(!(visited.contains(ng.key))) {
                double ans = dfs(ng.key, d, visited, g);
                if(ans!= -1.0)
                    return ans * ng.val;
            }
        }
        return -1.0;
            
    }
    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> g = new HashMap<>();
        for(int i=0;i<values.length;i++) {
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            g.putIfAbsent(src, new ArrayList<>());
            g.putIfAbsent(des, new ArrayList<>());
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1/values[i]));
        }
        return g;
    }
}