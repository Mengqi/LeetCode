public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        return solve(n, n);
    }

    private ArrayList<String[]> solve(int n, int line) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        if (line == 1) {
            for (int i = 0; i < n; i++) {
                String[] board = new String[n];
                board[0] = fillQueen(n, i);
                solutions.add(board);
            }
        } else {
            ArrayList<String[]> prefixes = solve(n, line-1);
            for (String[] prefix : prefixes) {
                for (int i = 0; i < n; i++) {
                    if (isPosValid(n, line, i, prefix)) {
                        String[] sln = Arrays.copyOf(prefix, prefix.length);
                        sln[line-1] = fillQueen(n, i);
                        solutions.add(sln);
                    }
                }
            }
        }
        return solutions;
    }

    private String fillQueen(int n, int pos) {
        String str = "";
        for (int i = 0; i < n; i++) {
            if (i == pos) {
                str = str + 'Q';
            } else {
                str = str + '.';
            }
        }
        return str;
    }

    private boolean isPosValid(int n, int line, int pos, String[] prefix) {
        int left = pos-1;
        int right = pos+1;
        for(int i = line-2; i >= 0; i--) {
            String boardLine = prefix[i];
            if ((left >= 0) && (boardLine.charAt(left) == 'Q')) {
                return false;
            }
            if ((right < n) && (boardLine.charAt(right) == 'Q')) {
                return false;
            }
            if (boardLine.charAt(pos) == 'Q') {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
