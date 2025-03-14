class Solution {
    public boolean candiesDist(int[] candies, long k, int partition) {
        long count = 0;
        for (int piles : candies) {
            count += piles / partition;
        }
        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int maxPiles = Arrays.stream(candies).max().getAsInt();
        int left = 1, right = maxPiles, ans = 0;

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
}