class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        // int prev = 0;
        // int curr = 1;
        // int k = 0;
        // int[] a = new int[nums.size()];
        // for(int num=0; num <  nums.size(); num++){
        //     a[num] = nums.get(num);
        // }
        // for(int i = 1; i < nums.size(); i++){
        //     if(a[i] > a[i-1]){
        //         curr++;
        //     }else{
        //         prev = curr;
        //         curr = 1;
        //     }

        //     k = Math.max( k , curr/2);
        //     k = Math.max(k , Math.min(curr , prev));
        // }
        // return k;
        int ans = 0, pre = 0, cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            ++cur;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}