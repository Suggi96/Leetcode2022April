class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Integer minCount = 0;
        
        Set<String> set = new HashSet<>(wordList);
        
        Queue<String> q = new LinkedList<>();
        
        q.add(beginWord);
        
        while (!q.isEmpty()){
            
            int size = q.size();
            minCount++;
            
            for (int k=0; k<size; k++){
                String latestWord = q.poll();
                
                if (latestWord.equals(endWord))
                    return minCount;
                                
                for (int i=0; i<latestWord.length(); i++){
    
                    String s1 = latestWord.substring(0,i);   
                    String s2 = latestWord.substring(i+1,latestWord.length());

                    for (int j=0; j<26; j++){
                        char temp = (char) ((int)'a'+j);
                        String s3 = s1+temp+s2;
                        if (set.contains(s3)){
                            set.remove(s3);
                            q.add(s3);
                        }
                    }
                }
            } 
        }     
        return 0;
    }
}