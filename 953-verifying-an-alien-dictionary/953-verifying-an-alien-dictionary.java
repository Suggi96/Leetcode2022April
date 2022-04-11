class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++) {
            map.put(order.charAt(i), i);
        }
        for(int i=1;i<words.length;i++) {
            if(compare(words[i-1], words[i]) > 0)
                return false;
        }
        return true;
    }
    public int compare(String first, String second) {
        int i = 0, j = 0;
        int compareVal = 0;
        while(i<first.length() && j<second.length() && compareVal==0) {
            compareVal = map.get(first.charAt(i)) - map.get(second.charAt(j));
            i++;
            j++;
        }
        //case to handle [helper, hel]
        if(compareVal==0) {
            return first.length() - second.length();
        }
        else
            return compareVal;
    }
}