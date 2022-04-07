class Solution {
    public boolean isAnagram(String s, String t) {
        char[] f1 = new char[26];
        char[] f2 = new char[26];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            f1[c - 'a']++;
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            f2[c - 'a']++;
        }
        if(Arrays.equals(f1, f2))
            return true;
        return false;
    }
}