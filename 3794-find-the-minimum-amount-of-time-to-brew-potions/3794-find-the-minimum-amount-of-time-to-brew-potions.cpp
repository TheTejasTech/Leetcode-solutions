class Solution {
public:
    long long minTime(vector<int>& skill, vector<int>& mana) {
        int n = skill.size();
        int m = mana.size();
        vector<long long> finishtime(n, 0);
        for (int j = 0; j < m; ++j) {
            finishtime[0] += 1LL* mana[j] * skill[0];

            for (int i = 1; i < n; ++i) {
                finishtime[i] = max(finishtime[i],finishtime[i - 1]) + 1LL * mana[j] * skill[i];
            }

            for (int i = n - 1; i > 0; --i) {
                finishtime[i - 1] = finishtime[i] - 1LL* mana[j] * skill[i];
            }
        }
        return finishtime[n - 1];
    }
};