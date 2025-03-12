class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int pc = 0, nc = 0;

    for (auto n : nums) {
        if (n > 0) {
            pc++;
        } else if (n < 0) {
            nc++;
        }
    }

    return max(pc, nc);
    }
};