class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total_score = Arrays.stream(nums).sum();

        int player1 = solve(0, n-1, nums);
        int player2 = total_score - player1;
        return player1 >= player2;
    }

    public int solve(int i, int j, int[] nums){
        if(i > j) return 0;
        if(i == j) return nums[i];

        int takei = nums[i] + Math.min(solve(i+1,j-1, nums) , solve(i+2, j, nums));
        int takej = nums[j] + Math.min(solve(i+1, j-1, nums), solve(i, j-2, nums));

        return Math.max(takei, takej);
    }
}