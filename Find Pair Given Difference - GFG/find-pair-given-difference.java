// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        /*a-b=n so check for
        n + b or a - n in map because for test case n = 7 we can have pair
        (17, 10) ie 17-10 = 7 or (10, 3) = ie 10 - 3 = 7
        Also in diff (a,b) = (b,a) eg (10,3) is same as (3,10) for n = 7
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<size;i++) {
            int a = n + arr[i];
            int b = arr[i] - n;
            if(map.containsKey(a) || map.containsKey(b))
                return true;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        return false;
        
    }
}