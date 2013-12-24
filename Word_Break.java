public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int sLength = s.length();
        boolean [][] match = new boolean [sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < sLength; j++) {
                match[i][j] = false;
            }
        }

        for (String word : dict) {
            int wLength = word.length();
            for (int i = 0; i < sLength; i++) {
                int j = i + wLength - 1;
                if (j < sLength) {
                    String substr = s.substring(i, i+wLength);
                    if (substr.equals(word)) {
                        match[i][j] = true;
                    }
                }
            }
        }

        for (int length = 2; length <= sLength; length++) {
            for (int i = 0; i <= sLength - length; i++) {
                int j = i + length - 1;
                if (match[i][j] == true) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (match[i][k] && match[k+1][j]) {
                        match[i][j] = true;
                        break;
                    }
                }
            }
        }

        return match[0][sLength-1];
    }
}
