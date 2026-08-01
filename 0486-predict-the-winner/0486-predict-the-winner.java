class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total_sum = Arrays.stream(nums).sum();

        int player1 = solve(0, n-1, nums);
        int player2 = total_sum - player1;

        if(player1 >= player2){
            return true;
        }else{
            return false;
        }
        //return false;
    }

    public int solve(int i, int j, int[] nums){
        if(i>j) return 0;
        if(i == j) return nums[i];

        int takei = nums[i] + Math.min(solve(i+2, j, nums) , solve(i+1,j-1, nums));
        int takej = nums[j] + Math.min(solve(i+1, j-1, nums), solve(i, j-2, nums));
        return Math.max(takei, takej);
    }
}