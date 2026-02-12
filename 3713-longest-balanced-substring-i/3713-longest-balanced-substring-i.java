class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[][] prefix = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';
            for (int c = 0; c < 26; c++) {
                prefix[i][c] = prefix[i - 1][c] + (c == ch ? 1 : 0);
            }
        }
        
        String pireltonak = s;
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int common = -1;
                boolean valid = true;
                int distinct = 0;
                for (int c = 0; c < 26; c++) {
                    int f = prefix[j + 1][c] - prefix[i][c];
                    if (f > 0) {
                        distinct++;
                        if (common == -1) {
                            common = f;
                        } else if (f != common) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid && distinct > 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}