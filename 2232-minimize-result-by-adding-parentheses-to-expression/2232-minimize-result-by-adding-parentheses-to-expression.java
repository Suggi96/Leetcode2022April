class Solution {
    public String minimizeResult(String expression) {
        // n1*(n2+n3)*n4
        //leftpart 0  upto + idx
        //rightpart +idx +1 upto n
        int smallestVal = Integer.MAX_VALUE;
        int plusIndex = -1;
        int leftIndex = -1;
        int rightIndex = -1;
        char[] exp = expression.toCharArray();
        for(int i=0;i<exp.length;i++) {
            if(exp[i]=='+') {
                plusIndex = i;
                break;
            }
        }
        for(int i=0;i<plusIndex;i++) {
            for(int j=plusIndex+1;j<exp.length;j++) {
                String n1Str = expression.substring(0,i);
                int n1 = 1;
                if(n1Str.length()>0) {
                    n1 = Integer.parseInt(n1Str);
                }
                String n2Str = expression.substring(i, plusIndex);
                int n2 = Integer.parseInt(n2Str);
                
                String n3Str = expression.substring(plusIndex+1, j+1);
                int n3 = Integer.parseInt(n3Str);
                
                String n4Str = expression.substring(j+1);
                int n4 = 1;
                if(n4Str.length()>0) {
                    n4 = Integer.parseInt(n4Str);
                }
                int curVal = n1*(n2+n3)*n4;
                if(curVal<smallestVal) {
                    smallestVal = curVal;
                    leftIndex = i;
                    rightIndex = j+1;
                }
            }
        }
        //building our output
        String ans = new String();
        ans += expression.substring(0, leftIndex);
        ans += "(";
        ans += expression.substring(leftIndex, rightIndex);
        ans += ")";
        ans += expression.substring(rightIndex);
        return ans;
    }
}