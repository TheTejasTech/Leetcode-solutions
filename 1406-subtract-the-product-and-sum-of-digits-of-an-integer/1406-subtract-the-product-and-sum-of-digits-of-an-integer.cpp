class Solution {
public:
    int subtractProductAndSum(int n) {
        int pr=1,s=0;
        while(n>0){
            int a=n%10;
            pr*=a;
            s+=a;
            n/=10;
        }
        return pr-s;
    }
};