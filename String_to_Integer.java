public class Solution {
    public int atoi(String str) {
        long sum = 0;

        int length = str.length();
        if (length == 0) {
            return 0;
        }
        
        int pos = 0;
        while (pos < length && str.charAt(pos) == ' ') {
            pos++;
        }
        
        boolean flag = true;    // true for '+'; false for '-'
        if (pos < length && str.charAt(pos) == '+') {
            flag = true;
            pos++;
        } else if (pos < length && str.charAt(pos) == '-') {
            flag = false;
            pos++;
        }
        
        while (pos < length && Character.isDigit(str.charAt(pos))) {
            int digit = str.charAt(pos) - '0';
            sum = sum * 10 + digit;
            if (sum > Integer.MAX_VALUE) {
                sum = (flag == true) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }
            pos++;
        }

        sum = (flag == true) ? sum : -sum;

        return (int) sum;
    }
}
