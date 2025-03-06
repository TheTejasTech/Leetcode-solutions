class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int missing,rep;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.size();j++){
                int curr=abs(grid[i][j]);
                int row=(curr-1)/(grid.size());
                int col=(curr-1)%(grid.size());
                if(grid[row][col]<0){
                    rep=abs(curr);
                    continue;
                }
                grid[row][col]*=(-1);
            }
        }
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.size();j++){
                if(grid[i][j]>0){
                    missing=i*(grid.size())+(j+1);
                    break;
                }
            }
        }
        return {rep,missing};
    }
};