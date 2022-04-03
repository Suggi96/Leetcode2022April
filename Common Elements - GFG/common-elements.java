// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking total count-1 of elements 
		    int n=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-1
		    ArrayList<Integer>v1=new ArrayList<>();
		    
		    //adding elements to the ArrayList-1
		    for(int i=0;i<n;i++)
		    {
		        v1.add(sc.nextInt());
		    }
		    
		    //taking total count-2 of elements 
		    int m=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-2
		    ArrayList<Integer>v2=new ArrayList<>();
		    
		    //adding elements to the ArrayList-2
		    for(int i=0;i<m;i++)
		    {
		        v2.add(sc.nextInt());
		    }
		    Solution ob = new Solution();
		    //calling the method common_element
		    //and passing ArrayList 1, 2 as arguments
		    //and storing the results in a new ArrayList
		    ArrayList<Integer>ans=ob.common_element(v1, v2);
		    
		    //printing the elements of the new ArrayList
		    for(int i:ans)
		    System.out.print(i+" ");
		    
		    System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public static ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2)
    {
        //Your code here
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i: v1)
            map1.put(i, map1.getOrDefault(i,0)+1);
        for(int i: v2) 
            map2.put(i, map2.getOrDefault(i, 0)+1);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map1.entrySet()) {
            int key1 = e.getKey();
            int val1 = e.getValue();
            if(map2.containsKey(key1)){
                int freq = Math.min(val1, map2.get(key1));
                int i = 0;
                while(i<freq) {
                    list.add(key1);
                    i++;
                }
            }
        }
        Collections.sort(list);
        return list;
            
    }
}