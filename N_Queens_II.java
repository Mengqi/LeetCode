public class Solution {
    private int count = 0;
    private int upper;

    public int totalNQueens(int n) {
        upper = (1<<n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int leftDiag, int rightDiag) {
        int pos, p;
        if (row != upper) {
            pos = upper & (~ (row | leftDiag | rightDiag));
            while (pos != 0) {
                p = pos & (-pos);
                pos = pos - p;
                solve(row+p, (leftDiag+p)<<1, (rightDiag+p)>>1);
            }
        } else {
            count++;
        }
    }
}
