class Solution {
    public int triangularSum(int[] nums) {
        // for( int i = nums.length - 1 ; i > 0; i--){
        //     for(int j = 0; j < i ; j++){
        //         nums[j] = (nums[j] + nums[j+1]) % 10;
        //     }
        // }
        // return nums[0];
        int n = nums.length;

        while (n > 1) {  
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; 
        }

        return nums[0];
    }
}