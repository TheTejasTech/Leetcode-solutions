class Solution {
public:
     
    int triangularSum(vector<int>& nums) {
        while(nums.size() > 1){
            vector<int> temp;
        
            for(int j = 0; j < nums.size() -1; j++){
                temp.push_back((nums[j]+nums[j+1]) %10) ;
            }
            nums= move(temp); 
        }
        return nums[0];
    }
};