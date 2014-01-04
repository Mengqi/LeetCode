public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int x, int y) {
        if (y == 9) {
            return true;
        }

        int nextX = x;
        int nextY = y;
        if (x < 8) {
            nextX++;
        } else {
            nextX = 0;
            nextY++;
        }

        if (board[x][y] == '.') {
            HashSet<Character> charSet = new HashSet<Character>();
            for (int i = 1; i <= 9; i++) {
                char ch = (char) (i + '0');
                charSet.add(ch);
            }

            for (int i = 0; i < 9; i++) {
                if (board[x][i] != '.') {
                    charSet.remove(board[x][i]);
                }

                if (board[i][y] != '.') {
                    charSet.remove(board[i][y]);
                }
            }

            int xStart = (x / 3) * 3;
            int yStart = (y / 3) * 3;
            for (int i = xStart; i < xStart+3; i++) {
                for (int j = yStart; j < yStart+3; j++) {
                    if (board[i][j] != '.') {
                        charSet.remove(board[i][j]);
                    }
                }
            }

            for (char ch : charSet) {
                board[x][y] = ch;
                if (solve(board, nextX, nextY)) {
                    return true;
                }
            }
            board[x][y] = '.';
            return false;
        } else {
            return solve(board, nextX, nextY);
        }
    }
}
