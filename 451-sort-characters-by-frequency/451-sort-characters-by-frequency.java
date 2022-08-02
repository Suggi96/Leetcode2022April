class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Pair<Character, Integer>> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            list.add(new Pair(e.getKey(), e.getValue()));
        }
        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();
        for(Pair<Character, Integer> p: list) {
            int size = p.getValue();
            while(size-- > 0) 
                sb.append(p.getKey());
        }
        return sb.toString();
    }
}