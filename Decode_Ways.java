public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if ((length == 0) || s.charAt(0) == '0') {
            return 0;
        }

        int [][] ways = new int [length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                ways[i][j] = 0;
            }
        }

        for (int i = 0; i < length; i++) {
            char curr = s.charAt(i);
            if (curr == '0') {
                ways[i][i] = 0;
            } else {
                ways[i][i] = 1;
            }
        }

        for (int i = 0; i < length-1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            if (isTwoDigitEncoding(curr, next)) {
                ways[i][i+1] = ways[i][i] * ways[i+1][i+1] + 1;
            } else {
                ways[i][i+1] = ways[i][i] * ways[i+1][i+1];
            }
       }

       for (int len = 3; len <= length; len++) {
           for (int i = 0; i <= length - len; i++) {
               int j = i + len - 1;
               ways[i][j] += ways[i][i]*ways[i+1][j];
               char curr = s.charAt(i);
               char next = s.charAt(i+1);
               if (isTwoDigitEncoding(curr, next)) {
                   ways[i][j] += ways[i+2][j];
               }
           }
       }

        return ways[0][length-1];
    }

    private boolean isTwoDigitEncoding(char curr, char next) {
        if (curr == '1') {
            return true;
        } else if ((curr == '2') && (next >= '0') && (next <= '6')) {
            return true;
        } else {
            return false;
        }
    }
}
