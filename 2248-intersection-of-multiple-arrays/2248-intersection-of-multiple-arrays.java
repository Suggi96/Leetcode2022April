class Solution {
    public List<Integer> intersection(int[][] nums) {
        int count = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0)+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue()==count) {
                list.add(e.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
}