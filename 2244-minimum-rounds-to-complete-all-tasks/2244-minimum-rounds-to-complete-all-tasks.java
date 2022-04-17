class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rounds = 0;
        for(int i: tasks) 
            map.put(i, map.getOrDefault(i, 0)+1);
        int count = 0;
        for(int freq: map.values()) {
            if(freq==1)
                return -1;
            while(freq>0) {
                if(freq%3==0) {
                    count += freq/3;
                    break;
                }
                else {
                    freq = freq - 2;
                    count++;
                }
            }
        }
        return count;
        
    }
}