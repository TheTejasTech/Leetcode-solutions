class Solution {
    public int m, n;
    public int[][] t;

    public int solve(int i, int j, String s1, String s2) {
        if (i >= m && j >= n)
            return 0;
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        if (i >= m) {
            return t[i][j] = s2.charAt(j) + solve(i, j + 1, s1, s2);
        }

        if (j >= n) {
            return t[i][j] = s1.charAt(i) + solve(i + 1, j, s1, s2);
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return t[i][j] = solve(i + 1, j + 1, s1, s2);
        }
        // two conditions 
        int del_s1_i = s1.charAt(i) + solve(i+1, j, s1, s2);
        int del_s2_j = s2.charAt(j) + solve(i, j+1, s1, s2);
        return t[i][j] = Math.min(del_s1_i , del_s2_j);
    }

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        
        t = new int[m+1][n+1];

        for(int i=0; i<= m; i++){
            for(int j = 0; j <= n ; j++){
                t[i][j] = -1;
            }
        }
        return solve(0, 0, s1,s2);
    }
}