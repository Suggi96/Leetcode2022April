class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        if(cost1>total && cost2>total)
            return 1;
        
        long numOfPens = total/cost1;
        long numOfPencils = 0;
        //start i=0 because we can buy 0 pens also irrespective of cost1
        for(int i=0;i<=numOfPens;i++) { 
            long moneyLeft = total - (long)i*cost1;
            //include 0 ways as 1 way in our ans so we add 1 in each iteration
            numOfPencils += 1 + moneyLeft/cost2; 
        }
        return numOfPencils;
    }
}