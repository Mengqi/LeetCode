public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int [][] cost = new int [m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = -1;
            }
        }
        cost[m-1][n-1] = grid[m-1][n-1];

        for (int j = n-1; j >= 0; j--) {
            for (int i = m-1; i >= 0; i--) {
                if ((i == m-1) && (j == n-1)) {
                    continue;
                }
                int valDown = -1;
                if (goDown(i,j,m,n)) {
                    valDown = grid[i][j] + cost[i][j+1];
                }
                int valRight = -1;
                if (goRight(i,j,m,n)) {
                    valRight = grid[i][j] + cost[i+1][j];
                }
                if (valDown == -1) {
                    cost[i][j] = valRight;
                } else if (valRight == -1) {
                    cost[i][j] = valDown;
                } else {
                    if (valDown < valRight) {
                        cost[i][j] = valDown;
                    } else {
                        cost[i][j] = valRight;
                    }
                }
            }
        }
        
        return cost[0][0];
    }
    
    private boolean goDown(int x, int y, int m, int n) {
        return y+1 < n;
    }
    
    private boolean goRight(int x, int y, int m, int n) {
        return x+1 < m;
    }
}