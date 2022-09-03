class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if(n==1)
            return  new int[] {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        for(int num=1;num<10;num++) {
            dfs(n-1, num, k, list);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
    private void dfs(int n, int num, int k, List<Integer> list) {
        if(n==0) {
            list.add(num);
            return;
        }
        int tailDigit = num % 10;
        if(tailDigit+k<10) 
            dfs(n-1, 10*num + tailDigit+k, k, list);
        
        if(k>0 && tailDigit-k>=0)
            dfs(n-1, 10*num + tailDigit-k, k, list);
    }
}