class Solution {
    public static int M = 1_000_000_007;
    public int concatenatedBinary(int n) {
        int digit = 0; long result =0;
        for(int i=1;i<=n;i++){
            if((i&(i-1)) == 0){
                digit++;
            }

            result = (((result << digit) %M) + i)%M;
        }
        return (int)result;
    }
}