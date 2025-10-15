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
        int n = nums.size();
        int cnt = 1;
        int precnt = 0;
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++cnt;
            } else {
                precnt = cnt;
                cnt = 1;
            }
            ans = Math.max(ans, Math.min(precnt, cnt));
            ans = Math.max(ans, cnt / 2);
        }

        return ans;
    }
}