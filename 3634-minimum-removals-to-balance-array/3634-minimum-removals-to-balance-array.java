class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        long maxe = nums[0];
        long mine = nums[0];
        int i = 0; 
        int j = 0;
        int l = 1;
        while( j < nums.length){
            mine = nums[i];
            maxe = nums[j];

            while(i < j && maxe > (long) (mine *k)){
                i++;
                mine = nums[i];
            }
            
            l = Math.max(l, j-i+1);
            j++;
        }
        return nums.length -l;
    }
}