public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        int length1 = s1.length();
        int length2 = s2.length();
        boolean[][] match = new boolean[length1+1][length2+1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                match[i][j] = false;
            }
        }

        match[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            if ((match[i-1][0] == true) && (s1.charAt(i-1) == s3.charAt(i-1))) {
                match[i][0] = true;
            }
        }

        for (int j = 1; j <= length2; j++) {
            if ((match[0][j-1] == true) && (s2.charAt(j-1) == s3.charAt(j-1))) {
                match[0][j] = true;
            }
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if ((match[i-1][j] == true) && (s1.charAt(i-1) == s3.charAt(i+j-1))) {
                    match[i][j] = true;
                    continue;
                }
                if ((match[i][j-1] == true) && (s2.charAt(j-1) == s3.charAt(i+j-1))) {
                    match[i][j] = true;
                }
            }
        }

        return match[length1][length2];
    }
}
