class Solution {
public:
    string makeFancyString(string s) {
        string result("");
        for (char ch : s) {   
            if(result.size()>1 && result.back()==ch && result[result.size()-2]==ch) {
                continue;
            }
            result+=ch;
        }
        return result;
    }
};

