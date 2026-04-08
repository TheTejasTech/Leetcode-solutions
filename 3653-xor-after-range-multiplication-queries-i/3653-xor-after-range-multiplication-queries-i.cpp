class Solution {
public:
    int m = (int) 1e9 + 7;
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        for(vector<int> q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            while(l <= r){
                nums[l] = (int) ((1L * nums[l] * v) % m);
                l += k;
            }
        }
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result; 
    }
};