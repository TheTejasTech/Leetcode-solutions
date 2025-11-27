class Solution {
public:
    long long maxSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();

        vector<long long> prefSum(n);
        prefSum[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i-1] + nums[i];
        }

        long long result = LLONG_MIN;

        for(int start = 0; start < k; start++) {
            long long currSum = 0;

            int i = start;

            while(i < n && i + k - 1 < n) {
                int j = i + k - 1;

                long long subSum = prefSum[j] - ((i > 0) ? prefSum[i-1] : 0);

                currSum = max(subSum, currSum + subSum);

                result = max(result, currSum);

                i += k;
            }
        }

        return result;
        // int n = nums.size();
        // long long prefixSum = 0, maxSum = LONG_LONG_MIN;
        // vector<long long> kSum(k, LONG_LONG_MAX / 2);
        // kSum[k - 1] = 0;
        // for (int i = 0; i < n; i++) {
        //     prefixSum += nums[i];
        //     maxSum = max(maxSum, prefixSum - kSum[i % k]);
        //     kSum[i % k] = min(kSum[i % k], prefixSum);
        // }
        // return maxSum;
    }
};