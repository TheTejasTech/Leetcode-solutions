class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;
            int temp = (1 << i);

            for (int num : nums) {
                if ((num & temp) != 0) {
                    countOnes++;
                }
            }

            if (countOnes % 3 != 0) {
                result |= temp;
            }
        }

        return result;
    }
}