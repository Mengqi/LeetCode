public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean [][] visited = new boolean [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int pos, int x, int y, boolean [][] visited) {
        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(pos)) {
            return false;
        }
        visited[x][y] = true;

        if (pos == word.length()-1) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        // move left
        if ((y > 0) && search(board, word, pos+1, x, y-1, visited)) {
            return true;
        }

        // move right

        if ((y < n-1) && (search(board, word, pos+1, x, y+1, visited))) {
            return true;
        }

        // move up
        if ((x > 0) && (search(board, word, pos+1, x-1, y, visited))) {
            return true;
        }

        // move down
        if ((x < m-1) && (search(board, word, pos+1, x+1, y, visited))) {
            return true;
        }

        visited[x][y] = false;
        return false;
    }
}
