class Solution {
    private int calculateMinPath(int row, int col, int totalRows, int[][] memo, boolean[][] visited, List<List<Integer>> triangle) {
        if (row == totalRows) {
            return 0;
        }

        if (!visited[row][col]) {
            visited[row][col] = true;
            memo[row][col] = Math.min(
                calculateMinPath(row + 1, col, totalRows, memo, visited, triangle),
                calculateMinPath(row + 1, col + 1, totalRows, memo, visited, triangle)
            ) + triangle.get(row).get(col);
        }

        return memo[row][col];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int totalRows = triangle.size();
        return calculateMinPath(0, 0, totalRows, new int[totalRows][totalRows], new boolean[totalRows][totalRows], triangle);
    }
}
