class Solution {
public:
    int maxOperations(string s) {
        int n = s.length();
        int i = 0;
        int count =0;
        int result = 0;
        while( i < n){
            if(s[i] == '0'){
                result += count;
                while(s[i] == '0' && i < n){
                    i++;
                }
            }else{
                count++;
                i++;
            }
            
        }

        return result;
    }
};