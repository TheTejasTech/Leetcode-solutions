class Solution {
public:
    int cnt = 0; 
    vector <vector <int>> adj; 
    vector <long long > s; 
    void dfs (int u ,int par, vector <int>& values, int& k ) {
        s[u] += values[u]; 
        for (int v : adj[u]) {
            if ( v == par ) continue; 
            dfs(v,u,values,k ); 
            if (s[v] % k != 0 ) {
                s[u] += 1LL*s[v];
            }
            else {
                cnt++; 
            }
        }
    }
    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        adj.resize(n);
        s.resize(n,0); 
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u); 
        }
        dfs(0,-1,values,k);
        return ((s[0] % k == 0 ) ? cnt + 1 : 0 );  
    }

    // int count = 0;
    // int dfs(int curr, int parent,
    //         unordered_map<int, vector<int>> &adj,
    //         vector<int> &values, int k) {
        

    //     int sum = 0;

    //     for (int &ngbr : adj[curr]) {
    //         if (ngbr != parent) {
    //             sum += dfs(ngbr, curr, adj, values, k);
    //             sum %= k;
    //         }
    //     }

    //     sum += values[curr];
    //     sum %= k;

    //     if (sum == 0) 
    //         count++;

    //     return sum;
    // }
    // int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
    //     unordered_map<int, vector<int>> adj;
    //     for (auto &edge : edges) {
    //         int u = edge[0];
    //         int v = edge[1];
    //         adj[u].push_back(v);
    //         adj[v].push_back(u);
    //     }

    //     count = 0;

    //     dfs(0, -1, adj, values, k);

    //     return count;
    // }
};