class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n<2) {
            return "";
        }
        char[] word = palindrome.toCharArray();
        for(int i=0;i<n/2;i++) {
            if(word[i]!='a') {
                word[i] = 'a';
                return String.valueOf(word);
            }
        }
        //crossed middle point. now we are at i=n/2
        //to make smallest possible non pal string replace last char with b
        word[n-1] = 'b';
        return String.valueOf(word);
        
    }
}