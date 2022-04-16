class Solution {
    public String longestPalindrome(String s) {
        String res = new String();
        int resLen = 0;
        int left = 0, right = 0;
        for(int i=0;i<s.length();i++) {
            //odd len palindrom check expansion from middle
            left = i;
            right = i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
            //even len palindrome check expansion from middle
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}