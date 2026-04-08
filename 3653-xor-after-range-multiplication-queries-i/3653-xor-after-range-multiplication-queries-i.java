class Solution {
    int m =(int) 1e9 + 7;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            while (l <= r) {
                nums[l] = (int) ((1L * nums[l] * v) % m);
                l += k;
            }
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}