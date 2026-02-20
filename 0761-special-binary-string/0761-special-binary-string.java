class Solution {
    public String makeLargestSpecial(String s) {
        int sum =0, start =0;
        List<String> special = new ArrayList<>(); 
        for(int i = 0; i < s.length(); i++){
            sum += (s.charAt(i)=='1') ? 1:-1;
            if(sum==0){
                String inner = s.substring(start+1,i);
                String proceed = "1"+ makeLargestSpecial(inner) + "0";
                special.add(proceed);
                start = i+1;
            }
        }

        Collections.sort(special, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for(String str: special){
            result.append(str);
        }
        return result.toString();
    }
}