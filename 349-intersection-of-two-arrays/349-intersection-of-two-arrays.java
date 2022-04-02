//TC: O(N)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i: nums1) {
            map.put(i, true);
        }
        List<Integer> list = new ArrayList<>();
        for(int i: nums2) {
            if(map.containsKey(i) && map.get(i)==true) {
                list.add(i);
                map.put(i, false);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}