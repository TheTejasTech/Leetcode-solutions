class Solution {
public:
    int maxIncreasingSubarrays(vector<int>& nums) {
        int n = nums.size(), ans = -1;
        vector<int> l(n, 0), r(n, n - 1);
        for(int i = 1; i < n; i++) {
            l[i] = nums[i] <= nums[i - 1] ? i : l[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            r[i] = nums[i] >= nums[i + 1] ? i : r[i + 1];
        }
        for(int i = 0; i < n - 1; i++) {
            ans = max(ans, min(i - l[i] + 1, r[i + 1] - i));
        }
        return ans;

        // int prev = 0;
        // int curr = 1;
        // int k = 0;
        // for(int i = 1; i < nums.size(); i++){
        //     if(nums[i] > nums[i-1]){
        //         curr++;
        //     }else{
        //         prev = curr;
        //         curr = 1;
        //     }

        //     k= max( k , curr/2);
        //     k = max(k , min(curr, prev));
        // }
        // return k;
    }
};