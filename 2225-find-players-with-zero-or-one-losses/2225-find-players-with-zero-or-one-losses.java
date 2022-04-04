class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        int rows = matches.length;
        int cols = matches[0].length;
        
        for(int i=0;i<rows;i++) 
            for(int j=0;j<cols;j++)
                players.add(matches[i][j]);
        
        Map<Integer, Integer> lostMatches = new HashMap<>();
        //initialise map with all players loosing initially 0 matches
        for(int i: players) {
            lostMatches.put(i, 0);
        }
            for(int i=0;i<rows;i++) {
                int playerNum = matches[i][1];
                lostMatches.put(playerNum, lostMatches.get(playerNum)+1);
            }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> exactlyOneLoss = new ArrayList<>();
        //adding players with 0 losses and 1 losses
        for(Map.Entry<Integer, Integer> e: lostMatches.entrySet()) {
            if(e.getValue()==0)
                noLoss.add(e.getKey());
            if(e.getValue()==1)
                exactlyOneLoss.add(e.getKey());
        }

        Collections.sort(noLoss);
        Collections.sort(exactlyOneLoss);
        ans.add(new ArrayList<>(noLoss));
        ans.add(new ArrayList<>(exactlyOneLoss));
        return ans;
        
    }
}