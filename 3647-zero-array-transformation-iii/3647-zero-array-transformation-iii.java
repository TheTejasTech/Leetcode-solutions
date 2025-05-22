import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
         int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>();  
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder());  
         
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int queryPos = 0;
        int appliedCount = 0;
        
        for (int i = 0; i < n; i++) { 
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }
            
            
            nums[i] -= usedQuery.size();
             
            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }
             
            if (nums[i] > 0) {
                return -1;
            }
             
            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }
        
        return queries.length - appliedCount;
    }
}
