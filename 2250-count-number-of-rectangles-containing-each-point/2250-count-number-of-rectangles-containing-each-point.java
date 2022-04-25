class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] res = new int[points.length];
        //according to question h and y ranges from 1 to 100
        List<List<Integer>> map = new ArrayList<>(101);
        //add all rectangle that ends with particular height
        for(int i=0;i<101;i++) {
            map.add(new ArrayList<>());
        }
        for(int[] rec: rectangles) {
            int l = rec[0];
            int h = rec[1];
            map.get(h).add(l);
        }
        //sort the cordinate of x for each height h ranges from 0 to 100 
        for(int i=0;i<101;i++) {
            Collections.sort(map.get(i));
        }
        for(int i=0;i<points.length;i++) {
            int count = 0;
            int x = points[i][0];
            int y = points[i][1];
            for(int j=y;j<101;j++) {
                List<Integer> rectanglesEndingWithHeightJ = map.get(j);
                int index = binarySearch(rectanglesEndingWithHeightJ, x);
                count += rectanglesEndingWithHeightJ.size() - index;
            }
            res[i] = count;
        }
        return res;
    }
    //return last index of element which is <= target
    //this returns number of elements <= target in list
    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while(left<right) {
            int mid = left + (right-left)/2;
            if(list.get(mid)>=target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}