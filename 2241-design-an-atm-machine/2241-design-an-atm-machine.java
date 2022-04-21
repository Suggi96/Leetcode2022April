class ATM {
    HashMap<Integer, Integer> map;
    long[] deno;
    public ATM() {
        deno = new long[5];
        map = new HashMap<>();
        map.put(4, 500);
        map.put(3, 200);
        map.put(2, 100);
        map.put(1, 50);
        map.put(0, 20);
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<banknotesCount.length;i++) {
            deno[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        int[] invalid = {-1};
        for(int i=4;i>=0;i--) {
            if(amount>=map.get(i)) {
                int notes = amount/map.get(i);
                if(notes>deno[i]) notes = (int)deno[i];
                //update deno[i] and remaining amount and ans array
                deno[i] -= notes;
                ans[i] += notes;
                amount = amount - (notes*map.get(i));
            }
        }
        if(amount==0)
            return ans;
        //handling amount!=0 so reset deno array using ans
        for(int i=0;i<5;i++)
            deno[i] += ans[i];
        return invalid;
        
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */