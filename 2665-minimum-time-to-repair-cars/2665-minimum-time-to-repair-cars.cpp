class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        long lo = 1, hi = 1e14;
    long ans = 0;
    while (lo <= hi) {
        long mid = lo + (hi - lo) / 2;
        long canr = 0;
        for (int r : ranks) {
            canr += (long)sqrt(mid / r);
        }
        if (canr >= cars) {
            hi = mid - 1;
            ans = mid;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
    
    }
};