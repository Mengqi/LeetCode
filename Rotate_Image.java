public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        rotate(matrix, 0, length-1);
    }

    private void rotate(int[][] matrix, int start, int end) {
        if (start > end) {
            return;
        }

        int length = end - start + 1;
        int prev;
        int curr;
        for (int i = 0; i < length-1; i++) {
            prev = matrix[start][start+i];
            curr = matrix[start+i][end];
            matrix[start+i][end] = prev;
            prev = curr;
            curr = matrix[end][end-i];
            matrix[end][end-i] = prev;
            prev = curr;
            curr = matrix[end-i][start];
            matrix[end-i][start] = prev;
            prev = curr;
            matrix[start][start+i] = prev;
        }

        rotate(matrix, start+1, end-1);
    }
}
