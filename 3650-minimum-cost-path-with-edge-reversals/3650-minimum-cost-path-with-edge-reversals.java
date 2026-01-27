
class Solution {

    public class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int minCost(int n, int[][] edges) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.computeIfAbsent(u , k -> new ArrayList()).add(new Pair(v , w));
            adj.computeIfAbsent(v , k -> new ArrayList()).add(new Pair(u , 2*w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.dist - b.dist);
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;

            if(d > dist[node]) continue;

            if(node == n-1) return d;

            if(!adj.containsKey(node)) continue;

            for(Pair ne : adj.get(node)){
                int nnode= ne.node;
                int weight = ne.dist;

                if(d + weight < dist[nnode]){
                    dist[nnode] = weight + d;
                    pq.offer(new Pair(nnode, dist[nnode]));
                }
            }
        }
        return -1;
    }
}