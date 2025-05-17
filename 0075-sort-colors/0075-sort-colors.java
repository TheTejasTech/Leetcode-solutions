class Solution {
    
    public static void swap(int[] arr,int st,int ed){
        int temp=arr[st];
        arr[st]=arr[ed];
        arr[ed]=temp;
    }
    public void sortColors(int[] nums) {
        int start=0,mid=0,end=nums.length-1;
        
        while(mid<=end){
            switch(nums[mid]){

                case 0:
                  swap(nums,start,mid);
                  mid++;
                  start++;
                  break;
                case 1:
                   mid++;
                   break;
                case 2:   
                   swap(nums,mid,end);
                   end--;
                   break;
            }
        }
        
    }
}