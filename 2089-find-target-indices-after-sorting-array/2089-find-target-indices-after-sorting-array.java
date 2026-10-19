class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ll = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                //return i;
                ll.add(i);
            }
        }
        return ll;
    }
}