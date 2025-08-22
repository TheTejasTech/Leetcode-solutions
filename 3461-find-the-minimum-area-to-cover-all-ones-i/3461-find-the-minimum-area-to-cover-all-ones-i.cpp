class Solution {
public:
    int minimumArea(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int maxRow = -1;
        int minRow = m;
        int mincol = n;
        int maxcol = -1;

        for( int i = 0; i< m ; i++){
            for( int j = 0; j < n ; j++){
                if(grid[i][j] == 1 ){
                    minRow = min(minRow , i );
                    mincol = min(mincol , j );
                    maxRow = max(minRow , i );
                    maxcol = max(maxcol , j );
                }
            }
        } 
        return (maxRow - minRow + 1) * (maxcol - mincol +1); 
    }
};