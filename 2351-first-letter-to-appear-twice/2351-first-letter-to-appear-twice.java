class Solution {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.get(c)!=null && map.get(c)==1) 
                return c;
            else
                map.put(c, map.getOrDefault(c, 0)+1);
        }
        return 'a';
    }
}