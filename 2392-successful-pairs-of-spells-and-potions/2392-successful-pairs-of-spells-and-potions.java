class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Arrays.sort(potions);
        // int n = spells.length, m = potions.length;
        // int[] result = new int[n];

        // for (int i = 0; i < n; i++) {
        //     long minPotion = (success + spells[i] - 1) / spells[i]; // Avoid overflow
        //     int index = binarySearch(potions, minPotion);
        //     result[i] = m - index;
        // }

        // return result;
        var l = potions.length;
        Arrays.sort(potions);
        var results = new int[spells.length];

        for (int i=0; i<spells.length; i++) { 
            var s = spells[i];
            int start = 0, end = l, magicIndex = -1;
            while (start < end) {
                var mid = start + (end - start) / 2;
                long test = (long) s * potions[mid];
                if (test >= success) {
                    magicIndex = mid;
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            if (magicIndex != -1) {
                results[i] = l - magicIndex;
            } else {
                results[i] = 0;
            }
        }
        return results;
    }
    // private int binarySearch(int[] potions, long minPotion) {
    //     int low = 0, high = potions.length - 1;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (potions[mid] < minPotion) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return low;
    // }


}
