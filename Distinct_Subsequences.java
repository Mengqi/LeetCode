public class Solution {
    public int numDistinct(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();
        
        if (sLength < tLength) {
            return 0;
        }
        
        if (tLength == 0) {
            return 1;
        }
        
        int[] match = new int [tLength+1];
        match[0] = 1;
        for (int i = 1; i <= tLength; i++) {
            match[i] = 0;
        }
        
        for (int i = 1; i <= sLength; i++) {
            for (int j = tLength; j >=1; j--) {
                if (T.charAt(j-1) == S.charAt(i-1)) {
                    match[j] = match[j] + match[j-1];
                }
            }
        }

        return match[tLength];
    }
}

