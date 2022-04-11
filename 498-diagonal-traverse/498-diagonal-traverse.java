class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
            int m = matrix.length;
            if (m == 0)
                return new int[0];
            int n = matrix[0].length;

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.computeIfAbsent(i + j, l -> new ArrayList<>()).add(matrix[i][j]);
                }
            }

            List<Integer> result = new ArrayList();
            for (int k = 0; k < m + n - 1; k++) {
                List<Integer> list = map.get(k);
                if (k % 2 == 0)
                    Collections.reverse(list);
                result.addAll(list);
            }

            return result.stream().mapToInt(x -> x).toArray();
    }
}