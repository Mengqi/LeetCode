public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        decorateMatrix(matrix, 0, n-1, 1);
        return matrix;
    }

    private void decorateMatrix(int[][] matrix, int start, int end, int firstNum) {
        if (start > end) {
            return;
        }

        int num = firstNum;
        // first row
        for (int i = start; i <= end; i++) {
            matrix[start][i] = num;
            num++;
        }
        // last column
        for (int i = start+1; i <=end; i++) {
            matrix[i][end] = num;
            num++;
        }
        // last row
        for (int i = end-1; i >= start; i--) {
            matrix[end][i] = num;
            num++;
        }
        // first column except matrix[start][start]
        for (int i = end-1; i >= start+1; i--) {
            matrix[i][start] = num;
            num++;
        }
        decorateMatrix(matrix, start+1, end-1, num);
    }
}
