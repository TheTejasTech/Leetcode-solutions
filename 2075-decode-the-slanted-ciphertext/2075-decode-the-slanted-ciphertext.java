class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int columns = l / rows;
        StringBuilder orig = new StringBuilder();
        for(int col=0; col <columns; col++){
            for(int j = col; j < l; j+= (columns+1)){
                orig.append(encodedText.charAt(j));
            }
        }
        while(orig.length() > 0 && orig.charAt(orig.length() -1) == ' '){
            orig.deleteCharAt(orig.length() -1);
        }
        return orig.toString();
    }
}