public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int [] height = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            // calculate height
            for (int j = 0; j < n; j++) {
                height[j] = 0;
                int k = i;
                while((k < m) && (matrix[k][j] == '1')) {
                    height[j]++;
                    k++;
                }
            }
            
            int max = largestRectangleArea(height);
            if (max > maxArea) {
                maxArea = max;
            }
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        Stack<Integer> indexStack = new Stack<Integer>();

        int maxArea = 0;
        for (int i = 0; i <= height.length; i++) {
            if ((i < height.length) && (indexStack.isEmpty() || height[indexStack.peek()] < height[i])) {
                indexStack.push(i);
            } else {
                int index = indexStack.pop();

                int width;
                if (indexStack.isEmpty()) {
                    width = i;
                } else {
                    width = i - (indexStack.peek() + 1);
                }

                int area = height[index] * width;
                maxArea = Math.max(maxArea, area);
                if (i < height.length || !indexStack.isEmpty()) {
                    i--;
                }
            }
        }

        return maxArea;
    }
}
