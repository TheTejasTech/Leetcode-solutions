class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;
        char[] c = s.toCharArray();
        Arrays.sort(c, 0, mid);
        for(int i = 0; i < n; i++){
            c[n - i - 1] = c[i];

        }
        return new String( c);
    }
}