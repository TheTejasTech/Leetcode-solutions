class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];

        result[0] = ".".repeat(n);
        String row = "#".repeat(n-1) + ".";
       
        for(int i = 1; i < m; i++){
            result[i] = row;
        }

        return result;
    }
}