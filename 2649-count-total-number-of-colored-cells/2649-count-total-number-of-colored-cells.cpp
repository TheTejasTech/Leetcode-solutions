#define ll long long int

class Solution {
public:
    long long coloredCells(int n) {
         ll cell=1;ll val=4;
        if(n==1)
           return 1;
        for(int i=2;i<=n;i++){
            cell+=val;
            val=4*i;
        }    
        return cell;
    }
};