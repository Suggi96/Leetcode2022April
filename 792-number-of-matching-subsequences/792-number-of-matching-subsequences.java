class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.putIfAbsent(c, new LinkedList<>());
        }
        for(String word: words) {
            char startChar = word.charAt(0);
            if(map.containsKey(startChar))
                map.get(startChar).add(word);
        }
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            char startChar = s.charAt(i);
            Queue<String> q = map.get(startChar);
            int size = q.size();
            for(int k=0;k<size;k++) {
                String str = q.poll();
                if(str.substring(1).length()==0)
                    ans++;
                else {
                   if(map.containsKey(str.charAt(1))) {
                       map.get(str.charAt(1)).add(str.substring(1));
                   }
                }
            }
        }
        return ans;
    }
}