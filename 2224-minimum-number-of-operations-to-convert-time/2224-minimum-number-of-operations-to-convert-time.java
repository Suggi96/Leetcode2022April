class Solution {
    public int convertTime(String current, String correct) {
        //current<=correct -> correct-current
        int x = toMins(current);
        int y = toMins(correct);
        int target = y - x;
        int ops = 0;
        while(target>0) {
            if(target>=60)
                target = target - 60;
            else if(target>=15 && target<60)
                target = target - 15;
            else if(target>=5 && target<15)
                target = target - 5;
            else 
                target = target - 1;
            ops++;
        }
        return ops;
        
    }
    private int toMins(String s) {
        int i = 0;
        while(s.charAt(i)!=':') {
            i++;
        }
        String hours = s.substring(0, i);
        String mins = s.substring(i+1, s.length());
        return Integer.valueOf(hours) * 60 + Integer.valueOf(mins);
    }
}