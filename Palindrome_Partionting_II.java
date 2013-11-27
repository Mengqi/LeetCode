public class Solution {
    public int minCut(String s) {
        int length = s.length();
        int[] cuts = new int[length];
        int[][] palindrome = new int [length][length];
        
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                palindrome[i][j] = 0;
            }
        }
        
        for (int i = 0; i < length; i++) {
            palindrome[i][i] = 1;
            cuts[i] = length - i - 1;
        }
        
        for (int i = length - 1; i >=0; i--) {
            for (int j = i; j < length; j++) {
                if (((j - i) > 1) && (palindrome[i+1][j-1] == 1) && (s.charAt(j) == s.charAt(i))) {
                    palindrome[i][j] = 1;
                } else if (j == (i+1)) {
                    if (s.charAt(j) == s.charAt(i)) {
                        palindrome[i][j] = 1;
                    }
                }
                int cutNum = cuts[i];
                if (palindrome[i][j] == 1) {
                    if (j == length-1) {
                        cutNum = 0;
                    } else {
                        cutNum = 1 + cuts[j+1];
                    }
                }
                if (cutNum < cuts[i]) {
                    cuts[i] = cutNum;
                }
            }
        }
        
        return cuts[0];
    }
}