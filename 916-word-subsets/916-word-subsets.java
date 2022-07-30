class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] maxFreqAccrossB = new int[26];
        for(String bStr: B) {
            int[] freqbStr = getFreq(bStr);
            for(int i=0;i<26;i++) 
                maxFreqAccrossB[i] = Math.max(maxFreqAccrossB[i], freqbStr[i]);
        }
        for(String aStr: A) {
            int[] freqaStr = getFreq(aStr);
            boolean foundAll = true;
            for(int i=0;i<26;i++) {
                if(freqaStr[i]<maxFreqAccrossB[i]) {
                    foundAll = false;
                    break;
                }
            }
            if(foundAll)
                res.add(aStr);
        }
        return res;
    }
    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}