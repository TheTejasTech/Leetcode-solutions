class Solution {
public:
    int areaOfMaxDiagonal(vector<vector<int>>& grid) {
        int n = grid.size();

        int maxDia = 0;
        int maxarea = 0;

        for( int i = 0 ;i < n ; i++){
            int l = grid[i][0];
            int w = grid[i][1];

            int dia = (l*l) + (w*w);

            int area = l * w;

            if( dia > maxDia){
                maxDia = dia;
                maxarea = area; 
            }else if( dia == maxDia ){
                maxarea = max ( maxarea , area);

            }
        }

        return maxarea;
    }
};