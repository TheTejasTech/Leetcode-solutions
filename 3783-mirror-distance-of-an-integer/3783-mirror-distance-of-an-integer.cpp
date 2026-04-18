class Solution {
public:
    int ger(int n){
        int rev = 0;
        while(n > 0){
            int d = n %10;
            rev = rev *10 + d; 
            n /= 10;
        }
        return rev;
    }
    int mirrorDistance(int n) {
        return abs(n - ger(n));
    }
};