class Solution {
public:
     
    int triangularSum(vector<int>& nums) {
        //int n = nums.size();
        for(int i = nums.size() -1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j+1]) % 10;
            }
        }
        return nums[0];
        // while(nums.size() > 1){
        //     vector<int> temp;
        
        //     for(int j = 0; j < nums.size() -1; j++){
        //         temp.push_back((nums[j]+nums[j+1]) %10) ;
        //     }
        //     nums= move(temp); 
        // }
        // return nums[0];
    }
};