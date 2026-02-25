class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] box = new Integer[arr.length ];
        for(int i=0;i<arr.length;i++){
            box[i]=arr[i];
        }
        Arrays.sort(box,(a,b)->{
            int ca = Integer.bitCount(a);
            int cb = Integer.bitCount(b);
            if(ca==cb){
                return a.compareTo(b);
            }
            return Integer.compare(ca,cb);
        });
        for(int i=0;i<arr.length;i++){
            arr[i]=box[i];
        }
        return arr;
    }
}