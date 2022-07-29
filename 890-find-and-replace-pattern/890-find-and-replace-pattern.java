class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(isPattern(word, pattern))
                res.add(word);
        }
        return res;
    }
    private boolean isPattern(String s, String p) {
        if(s.length()!=p.length())
            return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);
            
            if(!map1.containsKey(c1)) {
                map1.put(c1, c2);
            }
            if(!map2.containsKey(c2)) {
                map2.put(c2, c1);
            }
            
             if (map1.get(c1) != c2 || map2.get(c2) != c1) {
                return false;
            }
        }
        return true;
    }
}