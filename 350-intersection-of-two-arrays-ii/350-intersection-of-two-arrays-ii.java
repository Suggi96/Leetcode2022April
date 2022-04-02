class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i: nums2) {
            if(map.containsKey(i) && map.get(i)>0) {
                list.add(i);
                int freq = map.get(i);
                map.put(i, freq-1);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    } 
}