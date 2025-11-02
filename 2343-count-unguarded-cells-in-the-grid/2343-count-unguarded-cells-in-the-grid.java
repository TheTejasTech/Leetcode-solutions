class Solution {
    private int[] dir = {-1, 0, 1, 0, -1};

    private void dfs(int x, int y, int direction, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 2 || grid[x][y] == 3) 
            return;

        grid[x][y] = 1; // Marked as guarded
        if (direction == 0)        dfs(x - 1, y, direction, grid); // Up
        else if (direction == 1)   dfs(x, y + 1, direction, grid); // Right
        else if (direction == 2)   dfs(x + 1, y, direction, grid); // Down
        else if (direction == 3)   dfs(x, y - 1, direction, grid); // Left
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards and walls
        for (int[] guard : guards) 
            grid[guard[0]][guard[1]] = 2;

        for (int[] wall : walls) 
            grid[wall[0]][wall[1]] = 3;

        // Guard's line of sight
        for (int[] guard : guards) {
            for (int i = 0; i < 4; ++i) {
                int x = guard[0] + dir[i];
                int y = guard[1] + dir[i + 1];
                dfs(x, y, i, grid);
            }
        }

        // Count unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) 
                    unguarded++;
            }
        }

        return unguarded;
    }
}
