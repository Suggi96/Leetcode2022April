class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean neg = false;
        int num = 0;
        while(i<s.length() && s.charAt(i)==' ')
            i++;
       if(i<s.length() && s.charAt(i) == '-'){
			neg = true;
			i++;
		} else if(i<s.length() && s.charAt(i) == '+'){
			i++;
		}
        while(i<s.length() && Character.isDigit(s.charAt(i))) {
            int c = s.charAt(i) - '0';
            if((Integer.MAX_VALUE - c)/10 < num) {
                if(neg)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }   
            num = num * 10 + c;
            i++;
        }
        if(num==0) return 0;
        else {
            if(neg)
                return -num;
            else
                return num;
        }
    }
}