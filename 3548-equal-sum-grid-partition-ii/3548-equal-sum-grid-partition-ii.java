class Solution {
    public long total = 0;

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rows = new long[n];
        long[] cols = new long[m];

        //all grids sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        //horizontal cutting
        if (checkHozCuts(grid)) {
            return true;
        } 
        reverse(grid);
        if (checkHozCuts(grid)) {
            return true;
        }
        reverse(grid);
        int[][] transpose = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = grid[i][j];
            }
        }
        if (checkHozCuts(transpose)) {
            return true;
        }
        reverse(transpose);
        if (checkHozCuts(transpose)) {
            return true;
        }
        return checkHozCuts(transpose);
    }

    private boolean checkHozCuts(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<Long> s = new HashSet<>();
        long top = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) {
                s.add((long) grid[i][j]);
                top += grid[i][j];
            }
            long bottom = total - top;
            long diff = top - bottom;
            if (diff == grid[0][0])
                return true;
            if (diff == 0)
                return true;
            if (diff == grid[0][n - 1])
                return true;
            if (diff == grid[i][0])
                return true;
            if(i>0 && s.contains(diff) && n >1){
                return true;
            }
        }
        return false;
    }

    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;
        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;
            top++;
            bottom--;
        }
    }

}