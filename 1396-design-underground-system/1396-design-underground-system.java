class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> map1 = null;
    HashMap<String, List<Integer>> map2 = null;
    public UndergroundSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map1.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(map1.containsKey(id)) {
            String key = map1.get(id).getKey() + "->" + stationName;
            int time = t - map1.get(id).getValue();
            List<Integer> list = map2.get(key);
            if(list==null) {
                list = new ArrayList<>();
                list.add(time);
            }
            else {
                list.add(time);
            }
            map2.put(key, list);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double avg = 0;
        int sum = 0;
        String key = startStation + "->" + endStation;
        int n = map2.get(key).size();
        List<Integer> list = map2.get(key);
        for(int i: list)
            sum += i;
        avg = sum/(double)n;
        return avg;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */