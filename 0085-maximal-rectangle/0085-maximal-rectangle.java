import java.util.Stack;

class Solution {

    public int[] getNSR(int[] height ){
        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int[] right = new int[n];
        int pse = n;

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }

            if(st.isEmpty()){
                right[i] = pse;
            }else{
                right[i] = st.peek();
            }

            st.push(i);
        }
        return right;
    }

    public int[] getNSL(int[] height) {
        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int[] left = new int[n];
        int pse = -1;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }

            if(st.isEmpty()){
                left[i] = pse;
            }else{
                left[i] = st.peek();
            }

            st.push(i);
        }
        return left;
    }

    public int findArea(int[] height) {
        int n = height.length;
        int[] left = getNSL(height);
        int[] right = getNSR(height);
        int[] width = new int[n];

        for (int i = 0; i < n; i++){
            width[i] = right[i] - left[i] - 1;
        }

        int maxarea = 0;
        for(int i = 0; i < n; i++){
            int a = width[i] * height[i];
            if(maxarea < a){
                maxarea = a;
            }
        }
        return maxarea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];

        // first row
        for (int i = 0; i < n; i++) {
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        int maxArea = findArea(height);

        // remaining rows
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    height[col] = 0;
                } else {
                    height[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, findArea(height));
        }

        return maxArea;
    }
}
