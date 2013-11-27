public class Solution {
    public int maxArea(int[] height) {
        if ((height == null) || (height.length < 2)) {
            return 0;
        }

        int i = 0;
        int j = height.length-1;
        int maxArea = 0;
        while (i < j) {
            int area = 0;
            if (height[i] < height[j]) {
                area = height[i] * (j-i);
                i++;
            } else {
                area = height[j] * (j-i);
                j--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}