public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }

        int n = board[0].length;
        if (n == 0) {
            return;
        }

        boolean[][] captured = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                captured[i][j] = true;
            }
        }

        Queue<Point> pointQueue = new LinkedList<Point>();

        // leftmost column and rightmost column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                captured[i][0] = false;
                Point p = new Point(i, 0);
                pointQueue.add(p);
            }
            if (board[i][n-1] == 'O') {
                captured[i][n-1] = false;
                Point p = new Point(i, n-1);
                pointQueue.add(p);
            }
        }

        // top row and bottom row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                captured[0][j] = false;
                Point p = new Point(0, j);
                pointQueue.add(p);
            }
            if (board[m-1][j] == 'O') {
                captured[m-1][j] = false;
                Point p = new Point(m-1, j);
                pointQueue.add(p);
            }
        }

        while (!pointQueue.isEmpty()) {
            Point p = pointQueue.remove();

            // up neighboor
            if (p.x > 0) {
                int x = p.x - 1;
                int y = p.y;
                if (board[x][y] == 'O' && captured[x][y] == true) {
                    captured[x][y] = false;
                    Point point = new Point(x, y);
                    pointQueue.add(point);
                }
            }

            // down neighboor
            if (p.x < m-1) {
                int x = p.x + 1;
                int y = p.y;
                if (board[x][y] == 'O' && captured[x][y] == true) {
                    captured[x][y] = false;
                    Point point = new Point(x, y);
                    pointQueue.add(point);
                }
            }

            // left neighboor
            if (p.y > 0) {
                int x = p.x;
                int y = p.y - 1;
                if (board[x][y] == 'O' && captured[x][y] == true) {
                    captured[x][y] = false;
                    Point point = new Point(x, y);
                    pointQueue.add(point);
                }
            }

            // right neighboor
            if (p.y < n-1) {
                int x = p.x;
                int y = p.y + 1;
                if (board[x][y] == 'O' && captured[x][y] == true) {
                    captured[x][y] = false;
                    Point point = new Point(x, y);
                    pointQueue.add(point);
                }
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if ((board[i][j] == 'O') && (captured[i][j] == true)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
