class Solution {
    private int MAXN = 1001; 
    private int[] dfn = new int[MAXN]; 
    private int[] xor = new int[MAXN]; 
    private int[] size = new int[MAXN];
    private int dfnCnt;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Arrays.fill(dfn, 0, n, 0);
        dfnCnt = 0;
        f(nums, graph, 0);
        int m = edges.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0, a, b, pre, pos, sum1, sum2, sum3; i < m; i++) {
            a = Math.max(dfn[edges[i][0]], dfn[edges[i][1]]);
            for (int j = i + 1; j < m; j++) {
                b = Math.max(dfn[edges[j][0]], dfn[edges[j][1]]);
                if (a < b) {
                    pre = a;
                    pos = b;
                } else {
                    pre = b;
                    pos = a;
                }
                sum1 = xor[pos]; 
                if (pos < pre + size[pre]) {
                    sum2 = xor[pre] ^ xor[pos];
                    sum3 = xor[1] ^ xor[pre];
                } else {
                    sum2 = xor[pre];
                    sum3 = xor[1] ^ sum1 ^ sum2;
                }
                ans = Math.min(ans, Math.max(Math.max(sum1, sum2), sum3) - Math.min(Math.min(sum1, sum2), sum3));
            }
        }
        return ans;
    }
 
    private void f(int[] nums, List<List<Integer>> graph, int u) {
         
        int i = ++dfnCnt;
        dfn[u] = i;
        xor[i] = nums[u];
        size[i] = 1;
        for (int v : graph.get(u)) {
            if (dfn[v] == 0) {
                f(nums, graph, v);
                xor[i] ^= xor[dfn[v]];
                size[i] += size[dfn[v]];
            }
        }
    }
}