// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
              int ans = 0;
        int r = 0; //release pointer
        int distinct = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int a=0;a<s.length();a++) { // a acquire pointer
            Character c = s.charAt(a);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
                distinct++;
            }
            while(r<=a && distinct>k) { //invalid window so keep on releasing
                Character discardChar = s.charAt(r);
                r += 1;
                map.put(discardChar, map.get(discardChar)-1);
                if(map.get(discardChar)==0) {
                    map.remove(discardChar);
                    distinct--;
                }
            }
            if(distinct==k)
            ans = Math.max(ans, a - r + 1);
        }
        return ans==0?-1:ans;
    }
}