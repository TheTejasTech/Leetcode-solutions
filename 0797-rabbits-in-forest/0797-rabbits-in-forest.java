class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freq = new HashMap<>();
         
        for (int ans : answers) {
            freq.put(ans, freq.getOrDefault(ans, 0) + 1);
        }

        int total = 0;

        for (int x : freq.keySet()) {
            int count = freq.get(x);
            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) count / groupSize);
            total += groups * groupSize;
        }

        return total;
    }
}