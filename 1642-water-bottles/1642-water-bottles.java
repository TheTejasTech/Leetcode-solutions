class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // int count = 0;
        // if (numBottles >= 9) {
        //     if (numExchange % 3 == 0) {
        //         count++;
        //     } else if (numExchange % 3 == 1 || numExchange % 3 == 2) {
        //         count = count;
        //     }
        // }
        return numBottles + (numBottles - 1) / (numExchange - 1) ;
    }
}