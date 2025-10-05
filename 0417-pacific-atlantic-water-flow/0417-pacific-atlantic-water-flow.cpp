class Solution {
public:
    vector<vector<int>> solve(vector<vector<int>>& heights, int type) {
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        queue<pair<int, int>> q;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (type == 0 && (i == 0 || j == 0)) {
                    q.push({i, j});
                    vis[i][j] = 1;
                }
                if (type == 1 && (i == n - 1 || j == m - 1)) {
                    q.push({i, j});
                    vis[i][j] = 1;
                }
            }
        }

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while (!q.empty()) {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                    !vis[nrow][ncol] &&
                    heights[nrow][ncol] >= heights[row][col]) {
                    vis[nrow][ncol] = 1;
                    q.push({nrow, ncol});
                }
            }
        }
        return vis;
    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> vis1 = solve(heights, 0);
        vector<vector<int>> vis2 = solve(heights, 1);
        vector<vector<int>> ans;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis1[i][j] == 1 && vis2[i][j] == 1) {
                    ans.push_back({i, j});
                }
            }
        }
        return ans;
    }
};
