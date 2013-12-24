public class Solution {
    public int atoi(String str) {
        if ((str == null) || (str.length() == 0)) {
            return 0;
        }

        boolean positive = true;
        int pos = 0;
        while (pos < str.length()) {
            char ch = str.charAt(pos);
            if (ch == '+') {
                pos++;
                break;
            } else if (ch == '-') {
                positive = false;
                pos++;
                break;
            } else if ((ch >= '0') && (ch <= '9')){
                break;
            } else if (ch == ' '){
                pos++;
            } else {
                return 0;
            }
        }

        int sum = 0;
        while (pos < str.length()) {
            char ch = str.charAt(pos);
            if ((ch >= '0') && (ch <= '9')){
                int digit = ch - '0';
                if (positive) {
                    if (sum*10.0 + digit > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (-(sum*10.0 + digit) < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
                sum = sum * 10 + digit;
                pos++;
            } else {
                break;
            }
        }

        if (positive == false) {
            sum = -sum;
        }

        return sum;
    }
}
