class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, maxLength = 1, used = 0, n = nums.length;

        for (int right = 0; right < n; right++) {
            while ((used & nums[right]) != 0) {
                used ^= nums[left];
                left++;
            }
            used |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}