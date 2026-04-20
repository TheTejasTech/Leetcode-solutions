class Solution {
    public int maxDistance(int[] colors) {
        int dist =0;
        for(int i=0; i < colors.length; i++){
            for(int j=i; j < colors.length; j++)
            if(colors[i] == colors[j]){
                continue;
            }else{
                dist = Math.max(dist, Math.abs(i - j));
            }
        }
        return dist;
    }
}