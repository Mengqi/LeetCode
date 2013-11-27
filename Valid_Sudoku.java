public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if ((board == null) || (board.length == 0)) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        boolean result;

        // test row
        for (int i = 0; i < m; i++) {
            result = isRowValid(board, i);
            if (result == false) {
                return false;
            }
        }

        // test column
        for (int i = 0; i < n; i++) {
            result = isColValid(board, i);
            if (result == false) {
                return false;
            }
        }

        int mCount = m / 3;
        int nCount = n / 3;
        for (int i = 0; i < mCount; i++) {
            for (int j = 0; j < nCount; j++) {
                int x_start = i*3;
                int x_end = i*3 + 2;
                int y_start = j*3;
                int y_end = j*3+2;
                result = isCubeValid(board, x_start, x_end, y_start, y_end);
                if (result == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isCubeValid(char[][] board, int x_start, int x_end, int y_start, int y_end) {
        int[] numArr = new int[10];
        
        for (int i = 1; i <= 9; i++) {
            numArr[i] = 0;
        }
        
        for (int i = x_start; i <= x_end; i++) {
            for (int j = y_start; j <= y_end; j++) {
                char ch = board[i][j];
                if (('0' <= ch) && (ch <= '9')) {
                    int num = ch - '0';
                    int count = numArr[num];
                    if (count != 0) {
                        return false;
                    } else {
                        numArr[num] = 1;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isRowValid(char[][] board, int rowNum) {
        int[] numArr = new int[10];
        
        for (int i = 1; i <= 9; i++) {
            numArr[i] = 0;
        }

        char[] row = board[rowNum];
        int length = row.length;
        for (int i = 0; i < length; i++) {
            char ch = row[i];
            if (('0' <= ch) && (ch <= '9')) {
                int num = ch - '0';
                if (numArr[num] != 0) {
                    return false;
                } else {
                    numArr[num] = 1;
                }
            }
        }
        return true;
    }
    
    private boolean isColValid(char[][] board, int colNum) {
        int[] numArr = new int[10];
        
        for (int i = 1; i <= 9; i++) {
            numArr[i] = 0;
        }

        int length = board.length;
        for (int i = 0; i < length; i++) {
            char ch = board[i][colNum];
            if (('0' <= ch) && (ch <= '9')) {
                int num = ch - '0';            
                if (numArr[num] != 0) {
                    return false;
                } else {
                    numArr[num] = 1;
                }
            }
        }
        return true;
    }
}