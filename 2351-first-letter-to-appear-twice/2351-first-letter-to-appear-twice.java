class Solution {
    public char repeatedCharacter(String s) {
       Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.get(c)==null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
            else {
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c, list);
            }
        }
        char ans = '\0';
        int minIdx = Integer.MAX_VALUE;
        for(Map.Entry<Character, List<Integer>> e: map.entrySet()) {
            List<Integer> temp = e.getValue();
            if(temp.size()>=2 && temp.get(1)<minIdx) {
                ans = e.getKey();
                minIdx = temp.get(1);
            }
        }
        return ans;
    }
}