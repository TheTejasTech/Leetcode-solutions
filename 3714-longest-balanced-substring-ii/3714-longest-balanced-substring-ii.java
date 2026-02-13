 
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        String stromadive = s;
         
        int max1 = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                max1 = Math.max(max1, curr);
                curr = 1;
            }
        }
        max1 = Math.max(max1, curr);
         
        int max2 = 0;
        char[] chars = {'a', 'b', 'c'};
        for (int p = 0; p < 3; p++) {
            char x = chars[p];
            char y = chars[(p + 1) % 3];
            char z = chars[(p + 2) % 3];
            int ii = 0;
            while (ii < n) {
                if (s.charAt(ii) == z) {
                    ii++;
                    continue;
                }
                int start = ii;
                while (ii < n && s.charAt(ii) != z) {
                    ii++;
                }
                int endd = ii;
                int len_seg = endd - start;
                if (len_seg < 2) {
                    continue;
                }
                HashMap<Integer, Integer> map2 = new HashMap<>();
                int diff = 0;
                map2.put(0, 0);
                for (int j = start; j < endd; j++) {
                    char ch = s.charAt(j);
                    if (ch == x) {
                        diff += 1;
                    } else if (ch == y) {
                        diff -= 1;
                    }
                    int local_pos = j - start + 1;
                    Integer prevv = map2.get(diff);
                    if (prevv != null) {
                        max2 = Math.max(max2, local_pos - prevv);
                    }
                    if (!map2.containsKey(diff)) {
                        map2.put(diff, local_pos);
                    }
                }
            }
        }
         
        int max3 = 0;
        HashMap<Long, Integer> map3 = new HashMap<>();
        int d1 = 0;
        int d2 = 0;
        long offset = 100001L;
        long mult = 200003L;
        long keyy = (long) (d1 + offset) * mult + (d2 + offset);
        map3.put(keyy, 0);
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            if (ch == 'a') {
                d1 += 1;
                d2 += 1;
            } else if (ch == 'b') {
                d1 -= 1;
            } else if (ch == 'c') {
                d2 -= 1;
            }
            keyy = (long) (d1 + offset) * mult + (d2 + offset);
            Integer prev = map3.get(keyy);
            if (prev != null) {
                max3 = Math.max(max3, i - prev);
            }
            if (!map3.containsKey(keyy)) {
                map3.put(keyy, i);
            }
        }
        
        int ans = Math.max(max1, Math.max(max2, max3));
        return ans;
    }
}
