struct DSU {
    vector<int> p, sz;
    
    DSU(int n) {
        p.resize(n+1);
        sz.resize(n+1, 1);
        
        for (int j = 0; j <= n; j ++) p[j] = j;
    }
    
    int Leader (int x) {
        if (x == p[x]) return x;
        return (p[x] = Leader(p[x]));
    }
    
    void Merge (int x, int y) {
        x = Leader(x);
        y = Leader(y);
        
        if (x == y) return;
        if (sz[x] > sz[y]) swap(x, y);
        
        sz[y] += sz[x];
        p[x] = y;
    }
};

class Solution {
public:
    vector<int> minimumCost(int n, vector<vector<int>>& edges, vector<vector<int>>& query) {
        DSU dsu(n);
        for (auto e : edges) dsu.Merge (e[0], e[1]);
            
        vector<int> leader_val(n, -1);
        for (auto e : edges) {
            int x = dsu.Leader(e[0]);
            int y = dsu.Leader(e[1]);            
            assert (x == y);
            
            if (leader_val[x] == -1) leader_val[x] = e[2];
            else leader_val[x] &= e[2];
        }
                
        vector<int> ans;
        for (auto q : query) {
            if (q[0] == q[1]) {
                ans.push_back(0);
                continue;
            }
            int x = dsu.Leader(q[0]);
            int y = dsu.Leader(q[1]);
            
            if (x != y) ans.push_back(-1);
            else ans.push_back(leader_val[x]);            
        }
        return ans;
    }
};