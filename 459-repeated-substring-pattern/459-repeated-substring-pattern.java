//TC:  O(n2)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=0;i<len/2;i++) {
            String subStr = s.substring(0, i+1);
            if(len%subStr.length()==0) {
                int noOfRepetitions = len / subStr.length();
                StringBuilder temp = new StringBuilder();
                while(noOfRepetitions>0) {
                    temp.append(subStr);
                    noOfRepetitions--;
                }
                if(temp.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}