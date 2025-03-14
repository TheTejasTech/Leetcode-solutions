class Solution {
public:
    bool candiesDist(vector<int> &candies, long long k, int partion) {
    long long count = 0;
    for (int piles : candies) {
        count += piles / partion;
    }
    return count >= k;
}

int maximumCandies(vector<int>& candies, long long k) {
    int maxpiles = *max_element(candies.begin(), candies.end()); 
    int left = 1, right = maxpiles, ans = 0;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (candiesDist(candies, k, mid)) {
            left = mid + 1;
            ans = mid;
        } else {
            right = mid - 1; 
        }
    }
    return ans;  
}
};