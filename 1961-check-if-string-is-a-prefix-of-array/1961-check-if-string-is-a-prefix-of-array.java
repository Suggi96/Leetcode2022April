class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        StringBuilder str = new StringBuilder();
        while(i<words.length) {
            str.append(words[i]);
            if(str.toString().equals(s))
                return true;
            i++;
            if(str.toString().length()>s.length())
                return false;
        }
        return false;
    }
}