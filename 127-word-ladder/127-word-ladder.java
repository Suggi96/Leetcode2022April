class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s: wordList)
            set.add(s);
        if(!set.contains(endWord)) return 0;
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<String, Integer>(beginWord, 1));
        while(!q.isEmpty()) {
            Pair<String, Integer> p = q.remove();
            StringBuilder word = new StringBuilder(p.getKey());
            int ladder = p.getValue();
            if(word.toString().equals(endWord)) {
               // System.out.println("yes");
                return ladder;
            }
                
            set.remove(word.toString());
            for(int j=0;j<word.length();j++) {
                char c = word.charAt(j);
                for(int k=0;k<26;k++) {
                    char temp = (char)('a' + k);
                    word.setCharAt(j, temp);
                    if(set.contains(word.toString()))
                        q.add(new Pair<>(word.toString(), ladder+1));
                }
                word.setCharAt(j, c);
            }
        }
        return 0;
    }
}