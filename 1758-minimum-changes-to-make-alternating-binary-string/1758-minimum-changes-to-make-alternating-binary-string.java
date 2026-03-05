class Solution { 

    public int minOperations(String s) {
        
        int sz =0;
        
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i) == '1'){
                    sz++;
                }
            }else{
                if(s.charAt(i) == '0'){
                    sz++;
                }
            }
        }
        int so =s.length() - sz;
        return Math.min(sz,so);
    }
}