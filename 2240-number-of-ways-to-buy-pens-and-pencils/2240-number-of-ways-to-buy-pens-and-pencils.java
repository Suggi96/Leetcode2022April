class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        if(cost1>total && cost2>total)
            return 1;
        //count 0 ways as 1 way in our ans
        long numOfPens = total/cost1;
        long numOfPencils = 0;
        for(int i=0;i<=numOfPens;i++) {
            long moneyLeft = total - (long)i*cost1;
          //  System.out.println(moneyLeft);
            numOfPencils += 1 + moneyLeft/cost2;
        }
        return numOfPencils;
    }
}