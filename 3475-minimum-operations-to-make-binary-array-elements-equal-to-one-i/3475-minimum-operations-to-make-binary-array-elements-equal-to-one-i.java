class Solution {
    public int minOperations(int[] nums) {
        int flip = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                for (int j = i; j <= i + 2; j++) {
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
                flip++;
            }
        }
        
        if (nums[n - 2] == 1 && nums[n - 1] == 1) {
            return flip;
        }
        
        return -1;
    }
}