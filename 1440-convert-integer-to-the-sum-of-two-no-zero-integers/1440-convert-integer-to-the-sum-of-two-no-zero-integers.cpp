class Solution {
public:
    bool solve(int n){
       
        for(int i=0; i<6; i++){
            if(n==0) break;
            if(n%10==0) return 0;
            n= n/10;
        }
        return 1;
    }
    vector<int> getNoZeroIntegers(int n) {
        int m=n;
        while(n>0){
            if(solve(n/2) && solve(m - n/2)) return {n/2, m - n/2};
            n= n/2;
        }

        return {};
    }

};