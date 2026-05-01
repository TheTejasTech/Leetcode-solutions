class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        int sum = 0;
        int f0 = 0;
        int n = nums.size();
        for (int i = 0; i < n ; i++) {
            sum += nums[i];
            f0 += nums[i] * i; 
        }
        int maxe = f0;
        int curr = f0;
        for (int j = 1; j < n ; j++) {
            curr = curr + sum - n * nums[n - j];
            maxe = max(curr, maxe); 
        }

        return maxe;
    }
};