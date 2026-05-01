class Solution {

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f0 = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f0 += nums[i] * i;
            //count = Math.max(nums[i], count);
        }
        int max = f0;
        int curr = f0;
        for (int j = 1; j < nums.length; j++) {
            curr = curr + sum - n * nums[n - j];
            max = Math.max(curr, max);
            //tcount = tcount+ count;
        }

        return max;
    }
}