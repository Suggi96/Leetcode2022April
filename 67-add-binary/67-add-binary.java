class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int parity = 0;
        
        int i = a.length()-1;
        int j = b.length()-1;
        
        while(i >= 0 && j >= 0 ){
            if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                if(parity == 1) sb.append(1);
                else sb.append(0);
                parity = 1;
            }
            
            if(a.charAt(i) == '1' && b.charAt(j) == '0' || a.charAt(i) == '0' && b.charAt(j) == '1'){
                if(parity == 1){
                    sb.append(0);
                    parity = 1; 
                }
                else sb.append(1);
            }
            
            if(a.charAt(i) == '0' && b.charAt(j) == '0'){
                if(parity == 1){
                    sb.append(1);
                    parity = 0;
                }
                else sb.append(0);
            }
            i--;
            j--;
        }
        
        while(i != -1){
            if(a.charAt(i) == '0'){
                if(parity == 1){
                    sb.append(1);
                    parity = 0;
                }
                else sb.append(0);
                
            }
            if(a.charAt(i) == '1'){
                if(parity == 1){
                    sb.append(0);
                    parity = 1;
                }
                else sb.append(1);
            }
            i--;
        }
        
        while(j != -1){
            if(b.charAt(j) == '0'){
                if(parity == 1){
                    sb.append(1);
                    parity = 0;
                }
                else sb.append(0);
                
            }
            if(b.charAt(j) == '1'){
                if(parity == 1){
                    sb.append(0);
                    parity = 1;
                }
                else sb.append(1);
            }
            j--;
        }
        
        if(parity == 1) sb.append(1);
        
        sb.reverse();

        return sb.toString();
    }
}