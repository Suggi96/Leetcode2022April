// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int distinct = 0;
        //process first window
        for(int i=0;i<k;i++) {
            int currentVal = A[i];
            if(map.containsKey(currentVal)) {
                map.put(currentVal, map.get(currentVal)+1);
            }
            else {
                map.put(currentVal, 1);
                distinct++;
            }
        }
        ans.add(distinct);
        int release = 0;
        for(int acquire=k;acquire<n;acquire++) {
            int discardElement = A[release];
            map.put(discardElement, map.get(discardElement)-1);
            release++;
            
            if(map.get(discardElement)==0) {
                map.remove(discardElement);
                distinct--;
            }
            
            int currentVal = A[acquire];
            if(map.containsKey(currentVal)) {
                map.put(currentVal, map.get(currentVal)+1);
            }
            else {
                map.put(currentVal, 1);
                distinct++;
            }
            ans.add(distinct);
            
        }
        return ans;
    }
}

