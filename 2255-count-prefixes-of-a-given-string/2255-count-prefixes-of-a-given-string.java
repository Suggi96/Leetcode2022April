class Solution {
    public int countPrefixes(String[] words, String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String st: words) {
            map.put(st, map.getOrDefault(st, 0)+1);
        }
        int count = 0;
        StringBuilder pref = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            pref.append(s.charAt(i));
            if(map.containsKey(pref.toString())) {
                count += map.get(pref.toString());
            }
            
        }
        return count;
    }
}