class ATM {
    long[] deno = new long[5];
    Map<Integer, Integer> map = new HashMap<>();
    public ATM() {
        for(int i=0;i<5;i++)
            deno[i] = 0;
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
        for(int i=4;i>=0;i--) {
            if(amount>=map.get(i)) {
                int count = amount / map.get(i);
                if(count>deno[i]) count = (int)deno[i];
                deno[i] -= count;
                amount -= (count*map.get(i));
                ans[i] += count;
            }
            
        }
        if(amount==0)
                return ans;
            else {
                for(int i=0;i<5;i++)
                    deno[i] += ans[i];
                int[] tmp = {-1};
                return tmp;
            }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */