class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.equals(magazine))
            return true;
        int m = ransomNote.length();
        int n = magazine.length();
        if(m>n) return false;
        char[] f1 = new char[26];
        char[] f2 = new char[26];
        for(int i=0;i<m;i++) {
           char c = ransomNote.charAt(i);
            f1[c - 'a']++;
        }
        for(int i=0;i<n;i++) {
           char c = magazine.charAt(i);
            f2[c - 'a']++;
        }
        for(int i=0;i<26;i++) {
            if(f1[i]>f2[i])
                return false;
        }
        return true;
    }
}