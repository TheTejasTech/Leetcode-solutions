class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int shift = nums[i] % nums.length;

            int newIdx = (i + shift) % nums.length;

            if (newIdx < 0) {
                newIdx += nums.length;

            }
            result[i] = nums[newIdx];
        }
        return result;
    }
}