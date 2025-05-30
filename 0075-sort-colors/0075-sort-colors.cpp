class Solution {
public:
    void swap(vector<int>& arr,int p,int q){
        int temp=arr[p];
        arr[p]=arr[q];
        arr[q]=temp;
    }
    void sortColors(vector<int>& nums) {
        int start=0, mid=0,end=nums.size()-1;

        while(mid<=end){
            switch(nums[mid]){

                case 0:
                  swap(nums,start,mid);
                  mid++;
                  start++;
                  break;
                case 1:
                  mid++;break;
                case 2:
                  swap(nums,mid,end);
                  end--;
                  break;
            }
        }
    }
};