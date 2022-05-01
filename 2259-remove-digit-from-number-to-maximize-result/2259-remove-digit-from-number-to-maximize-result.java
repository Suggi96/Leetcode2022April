class Solution {
    public String removeDigit(String number, char digit) {
        for(int i=0;i<number.length();i++) {
            if(number.charAt(i)==digit) {
                if(i+1<number.length() && number.charAt(i+1)>digit) {
                    return number.substring(0, i) + number.substring(i+1);
                }
            }
        }
        int idx = 0;
        for(int i=number.length()-1;i>=0;i--) {
            if(number.charAt(i)==digit) {
                idx = i;
                break;
            }  
        }
        return number.substring(0, idx) + number.substring(idx+1);
    }
}