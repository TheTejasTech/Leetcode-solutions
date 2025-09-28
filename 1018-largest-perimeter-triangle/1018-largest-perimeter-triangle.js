/**
 * @param {number[]} nums
 * @return {number}
 */
var largestPerimeter = function (nums) {
    nums.sort((a,b) => a-b);
    if (nums.length < 3) return 0;
    for (var i = nums.length - 1; i >= 2; i--) {
        if (nums[i] < nums[i - 1] + nums[i - 2]) {
            return nums[i] + nums[i - 2] + nums[i - 1];
        }
    }
    return 0;
};