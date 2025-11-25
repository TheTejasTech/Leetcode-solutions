class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 ==0) return -1;
        int prevrem = 0;
        for(int i = 0 ; i<= k ; i++){
            prevrem = (prevrem * 10 + 1 ) % k;
            if(prevrem == 0) {return i+1;}
        }
        return -1;
    }
}