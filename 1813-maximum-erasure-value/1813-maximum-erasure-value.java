class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int r=0,l=0;
            Set<Integer>st=new HashSet<>();
            int sum=0;
            int max=0;
            while(r<nums.length)
            {
                int k=nums[r];
                    while(st.contains(k))
                    {
                        st.remove(nums[l]);
                        sum-=nums[l];
                        l++;
                    }
                    st.add(k);
                    sum += k;
                    max = Math.max(max, sum);
                    r++;
            }  
            return max;
    }
}