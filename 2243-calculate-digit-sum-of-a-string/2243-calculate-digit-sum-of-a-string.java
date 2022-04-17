class Solution {
    public String digitSum(String s, int k) {
        if(k>=s.length())
            return s;
        List<String> list = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            while(i<s.length()) {
                if(i+k>=s.length()) {
                list.add(s.substring(i));
            }
            else {
                list.add(s.substring(i, i+k));
            }
            i = i+k;
        }
            for(String x: list)
                System.out.print(x+" ");
            System.out.println();
            s = merge(list);
            list.clear();
            i = 0;
            if(s.length()<=k)
                break;
        }
        return s;
    }
    private String merge(List<String> list) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for(String s: list) {
            for(char c: s.toCharArray())
                sum += Integer.parseInt(String.valueOf(c));
            System.out.println(sum);
            res.append(sum);
            sum = 0;
        }
        System.out.println("res="+res.toString());
        return res.toString();
    }
}