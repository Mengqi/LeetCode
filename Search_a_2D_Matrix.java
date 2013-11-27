public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        return search(matrix, target, 0, m-1, 0, n-1);
        
    }

    public boolean search(int[][] matrix, int target, int s_m, int e_m, int s_n, int e_n) {
        if ((s_m > e_m) || (s_n > e_n)) {
            return false;
        }
        
        if (s_m < e_m) {
            int mid_m = (s_m + e_m) / 2;
            int min = matrix[mid_m][0];
            int max = matrix[mid_m][e_n];
            if (target > max) {
                return search(matrix, target, mid_m+1, e_m, s_n, e_n);
            } else if (target < min) {
                return search(matrix, target, s_m, mid_m-1, s_n, e_n);
            } else {
                return search(matrix, target, mid_m, mid_m, s_n, e_n);
            }
        } else {
            int mid_n = (s_n+e_n) / 2;
            int mid_num = matrix[s_m][mid_n];
            if (target == mid_num) {
                return true;
            } else if (mid_num > target) {
                return search(matrix, target, s_m, s_m, s_n, mid_n-1);
            } else {
                return search(matrix, target, s_m, s_m, mid_n+1, e_n);
            }
        }
    }
}