class Solution {
public:
    bool hasA(int h, vector<int>& citations) {
        int count = 0;
        for (int cite_count : citations) {
            if (cite_count >= h)
                count++;
        }
        return count >= h;
    }
    int hIndex(vector<int>& citations) {
        int low = 0, high = citations.size();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (hasA(mid, citations))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
};