class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        //building maxFreq array for entire B
        int[] maxFreqB = new int[26];
        List<String> res = new ArrayList<>();
        for(String bStr: B) {
            int[] temp = getFreq(bStr);
            for(int i=0;i<26;i++) 
                maxFreqB[i] = Math.max(maxFreqB[i], temp[i]);
        }
        
        //now check if for each aStr if freqA >= maxFreqB then aStr is valid answer
        for(String aStr: A) {
            int[] freqA = getFreq(aStr);
            boolean valid = true;
            for(int i=0;i<26;i++) {
                if(freqA[i]<maxFreqB[i]) {
                    valid = false;
                    break;
                }
            }
            if(valid)
                res.add(aStr);
        }
        return res;
    }
    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray())
            freq[c - 'a']++;
        return freq;
    }
}