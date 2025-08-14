class Solution {
public:
    string largestGoodInteger(string num) {
        char highest = '\0';
        for(int i =1;i<=num.length()  -1; i++){
            if(num[i] == num[i+1] && num[i] == num[i-1]){
                highest = max(highest , num[i]);
            }
        }
        return highest == '\0' ? "" : string(3, highest);
    }
};