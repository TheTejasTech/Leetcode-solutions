class Solution {
    
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i]= Math.max(prefix[i-1] , nums[i]);
        }

        int[] suf = new int[n];
        suf[n-1]= nums[n-1]; 
        for(int i= n-2;i>=0; i--){
            suf[i] = Math.min(suf[i+1] , nums[i]);
        }
        for(int i=0;i<n;i++){
            if(prefix[i]- suf[i] <= k){
                return i;
            }
        }
        return -1;
    }
}