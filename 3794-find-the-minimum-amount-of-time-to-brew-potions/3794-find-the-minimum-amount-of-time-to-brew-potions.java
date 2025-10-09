class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] finishtime = new long[n];//(n, 0);
        for (int j = 0; j < m; ++j) {
            finishtime[0] += (long) mana[j] * skill[0];

            for (int i = 1; i < n; ++i) {
                finishtime[i] = Math.max(finishtime[i],finishtime[i - 1]) + (long) mana[j] * skill[i];
            }

            for (int i = n - 1; i > 0; --i) {
                finishtime[i - 1] = finishtime[i] - (long) mana[j] * skill[i];
            }
        }
        return finishtime[n - 1];
    }
}