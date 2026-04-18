class Solution {
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        int rev = Integer.parseInt(sb.toString());
        rev = n - rev;
        rev = Math.abs(rev);
        return rev;
    }
}