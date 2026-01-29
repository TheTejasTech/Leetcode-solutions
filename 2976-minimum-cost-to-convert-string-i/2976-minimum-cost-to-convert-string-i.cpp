class Solution {
public:
    long long minimumCost(string source, string target, vector<char>& original, vector<char>& changed, vector<int>& cost) {
        vector<vector<long long>> min_size(26,vector<long long>(26,INT_MAX));
        int n=original.size();

        for(int i=0;i<n;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            int w=cost[i];

            if(w<min_size[u][v]){
                min_size[u][v]=w;
            }
        }

        for(int via=0;via<26;via++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(min_size[i][via]!= INT_MAX && min_size[via][j]!= INT_MAX){
                        if(min_size[i][via]+min_size[via][j]<min_size[i][j]){
                            min_size[i][j]=min_size[i][via]+min_size[via][j];
                        }
                    }
                }
            }
        }

        int size=source.size();
        long long total_cost=0;

        for(int i=0;i<size;i++){
            if(source[i]!=target[i] ){
                long long cost=min_size[source[i]-'a'][target[i]-'a'];
                if(cost==INT_MAX){
                    return -1;
                }
                total_cost+=cost;
            }
        }

        return total_cost;

    }
};