class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> result;
        
        for (auto num : nums) {
            vector<int> temp;
            
            // Extract digits in reverse
            while (num > 0) {
                temp.push_back(num % 10);
                num /= 10;
            }
            
            // Add in correct order
            for (int i = temp.size() - 1; i >= 0; i--) {
                result.push_back(temp[i]);
            }
        }
         
        
        return result;
    }
};