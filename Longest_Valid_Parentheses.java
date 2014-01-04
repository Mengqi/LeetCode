public class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }

        int maxPLength = 0;
        int[] validLength = new int[length];
        validLength[length-1] = 0;

        for (int i = length - 2; i >= 0; i--) {
            int vLength = 0;
            int start = i;
            while ((start <= length-2) && (s.charAt(start) == '(')) {
                int end = start + validLength[start+1] + 1;
                if (end < length) {
                    char ch = s.charAt(end);
                    if (ch == ')') {
                        vLength = vLength + validLength[start+1] + 2;
                    } else {
                        break;
                    }
                }
                start = end + 1;
            }
            validLength[i] = vLength;

            if (maxPLength < validLength[i]) {
                maxPLength = validLength[i];
            }
        }

        return maxPLength;
    }
}
