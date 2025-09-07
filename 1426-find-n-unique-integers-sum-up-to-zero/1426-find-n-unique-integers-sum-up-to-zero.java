class Solution {
    public int[] sumZero(int n) {
        int i = 0 ; 
        int j = n -1;
        int[] result = new int[n];
        int start = 1;
        while(i < j ){
            result[i] = start;
            result[j] = -start;
            start++;
            i++;
            j--;
        }
        return result;
    }
}