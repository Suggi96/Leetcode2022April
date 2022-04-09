// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        HashMap<String, Long> map = new HashMap<>();
        map.put("0*0", 1l);
        int zc=0, oc=0, tc=0;
        long ans = 0;
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c=='0') zc++;
            else if(c=='1') oc++;
            else tc++;
            String key = (zc-oc) + "*" + (zc-tc);
            if(map.containsKey(key)) {
                ans += map.get(key);
                map.put(key, map.get(key)+1l);
            }
            else 
                map.put(key, 1l);
        }
        return ans;
    }
} 