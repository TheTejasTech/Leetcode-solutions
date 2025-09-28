class Solution {
    public int largestPerimeter(int[] nums) {
        int formTriangle = 0;
        if (nums.length < 3)
            return 0;
        // for(int i = 0 ; i < nums.length-2; i++){
        //     if( nums[i] + nums[i+1] < nums[i+2]){
        //         return 0;
        //         //break;
        //     }
        //     else if(nums[i] + nums[i+1] > nums[i+2] || nums[i] + nums[i+2] > nums[i+1] || nums[i+1] + nums[i+2] > nums[i]){
        //         formTriangle++;
        //     }

        // }
        // for (int i = 0; i < nums.length - 2; i++) {
        //     formTri(nums[i], nums[i + 1], nums[i + 2], nums);
        //     formTri(nums[i + 2], nums[i + 1], nums[i], nums);
        //     formTri(nums[i + 1], nums[i], nums[i + 2], nums);
        //     formTri(nums[i + 1], nums[i + 2], nums[i], nums);
        // }
        // return formTriangle;
        Arrays.sort(nums);
        for(int i = nums.length -1; i >= 2; i--){
            if(nums[i] < nums[i-1] +nums[i-2]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }

    public int formTri(int a, int b, int c, int[] nums) {
        int formTriangle = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[i + 1] > nums[i + 2] || nums[i] + nums[i + 2] > nums[i + 1]
                    || nums[i + 1] + nums[i + 2] > nums[i]) {

                formTriangle++;
            }
        }
        return formTriangle;
    }
}