class Solution {
public:
    bool divideArray(vector<int>& nums) {
        unordered_set<int> remaining;
        for(int i:nums){
            if(remaining.count(i)) remaining.erase(i) ;
            else                   remaining.insert(i) ; 
        }
        return remaining.size()==0; 
    }
};