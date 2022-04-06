// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(prefixSum, 1);
        int ans = 0;
        for(int val: arr) {
            if(val==0)
                prefixSum += -1;
            else 
                prefixSum += val;
            if(map.containsKey(prefixSum)) {
                ans += map.get(prefixSum);
                map.put(prefixSum, map.get(prefixSum)+1);
            }
            else {
                map.put(prefixSum, 1);
            }
        }
        return ans;
    }
}


