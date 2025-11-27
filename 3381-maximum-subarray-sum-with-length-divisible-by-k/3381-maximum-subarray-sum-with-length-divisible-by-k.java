class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        
        int n = nums.length;

        long[] prefSum = new long[n];
        prefSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }

        long result = Long.MIN_VALUE;

        for (int start = 0; start < k; start++) {
            long currSum = 0;

            int i = start;
            while (i < n && i + k - 1 < n) {
                int j = i + k - 1;

                long subSum = prefSum[j] - (i > 0 ? prefSum[i - 1] : 0);

                currSum = Math.max(subSum, currSum + subSum);

                result = Math.max(result, currSum);

                i += k;
            }
        }

        return result;
    }
}// int n = nums.length;
        // int sum = 0;
        // int[] prefsum = new int[nums.length];
        // prefsum[0] = nums[0];
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i; j < nums.length - i; j++){
        //         //sum = nums[i] + nums[j];
        //         sum = Math.max(sum , nums[i] + nums[j]);
        //     }
        // }