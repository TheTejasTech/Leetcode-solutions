class Solution {
public:
    // int lowerBound( int l ,  int r , vector<int>& potions, long long minpotion){
    //     int ps = -1;
    //     while( l <= r){
    //         int mid = l  + ( r-l ) / 2;
    //         if(potions[mid] >= minpotion){
    //             ps = mid;
    //             r = mid -1;

    //         }else{ l = mid;}
    //     }
    //     return ps;
    // }

    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        // int m = spells.size(); 
        // int n = potions.size();
        // sort(begin(potions) , end(potions));

        // vector<int> answers;

        // for(int i = 0 ; i <  m ; i++){
        //     int spell = spells[i];
        //     long long minpotion = ceil((1.0 * success) / spell);

        //     int index  = lowerBound(0 , n - 1 , potions , minpotion);
        //     int count = n - index;

        //     answers.push_back(count);
        // }
        // return answers;
        int m = spells.size(); 
        int n = potions.size();
        sort(begin(potions) , end(potions));

        vector<int> answers;

        for(int i = 0 ; i <  m ; i++){
            int spell = spells[i];
            long long minpotion = ceil((1.0 * success) / spell);

            int index  = lower_bound(begin(potions) , end(potions), minpotion) - begin(potions);
            int count = n - index;

            answers.push_back(count);
        }
        return answers;
    }
};