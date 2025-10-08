class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        // int m = spells.size();
        // for(int i=0 ; i < potions.length ; i++){
        //     potions[i] = spells[i] * potions[i];

        //     if(potions[i] >=  sucsess){
        //         pairs[i]  = potions[i];
        //     }
        // }
        Arrays.sort(potions); 
        //List<Integer> result = new ArrayList<>();

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];  
            int index = lowerBound(potions, (int)minPotion);  
            result[i] = potions.length - index;
        }

        return result;

    }
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
