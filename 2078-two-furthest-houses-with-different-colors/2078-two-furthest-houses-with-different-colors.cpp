class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int d =0;
        for(int i=0; i < colors.size(); i++){
            for(int j=i; j < colors.size(); j++)
            if(colors[i] == colors[j]){
                continue;
            }else{
                d = max(d, abs(i - j));
            }
        }
        return d;
    }
};