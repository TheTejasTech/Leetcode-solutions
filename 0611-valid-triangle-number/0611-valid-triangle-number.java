class Solution {
    public int triangleNumber(int[] nums) {
        int count =0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int k = n-1; k > 1; k--) {    // k is the largest side
            int i = 0, j = k-1;           // two pointers
            
            while(i < j) {
                if(nums[i] + nums[j] > nums[k]) {
                    count += (j - i);      
                    j--;
                } else {
                    i++;
                }
            }
        }
        
        return count;
    }
}