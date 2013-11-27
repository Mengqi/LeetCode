public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ((obstacleGrid == null) || (obstacleGrid.length == 0)) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if ((m == 0) || (n == 0)) {
            return 1;
        }
        
        int[][] ways = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ways[i][j] = 0;
            }
        }
        
        if (obstacleGrid[m-1][n-1] != 1) {
            ways[m-1][n-1] = 1;
        }
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    if (goDown(i,j,m,n)) {
                        ways[i][j] = ways[i][j] + ways[i][j+1]; 
                    }
                    if (goRight(i,j,m,n)) {
                        ways[i][j] = ways[i][j] + ways[i+1][j];
                    }
                }
            }
        }
        
        return ways[0][0];
        
        
    }
    
    private boolean goDown(int x, int y, int m, int n) {
        return (y+1 < n);
    }
    
    private boolean goRight(int x, int y, int m, int n) {
        return (x+1 < m);
    }
}