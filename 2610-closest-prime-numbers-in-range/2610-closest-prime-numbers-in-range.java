class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primesInRange = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primesInRange.add(i);
            }
        }
        
        if (primesInRange.size() < 2) {
            return new int[] {-1, -1};
        }
        
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        for (int i = 1; i < primesInRange.size(); i++) {
            int diff = primesInRange.get(i) - primesInRange.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primesInRange.get(i - 1);
                result[1] = primesInRange.get(i);
            }
        }
        
        return result;
    }
}