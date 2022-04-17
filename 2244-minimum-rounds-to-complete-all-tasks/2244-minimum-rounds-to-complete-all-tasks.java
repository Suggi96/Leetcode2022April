class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rounds = 0;
        for(int i: tasks) 
            map.put(i, map.getOrDefault(i, 0)+1);
        if(invalid(map))
            return -1;
        for(int i=0;i<tasks.length;i++) {
            if(map.get(tasks[i])>0) {
                int freq = map.get(tasks[i]);
                if(freq%3==0 || freq%2==1) //odd case
                    map.put(tasks[i], freq-3);
                else //even case
                    map.put(tasks[i], freq-2);
                rounds++;
            }
            
        }
        return rounds;
        
    }
        
    private boolean invalid(HashMap<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue()<2)
                return true;
        }
        return false;
    } 
}