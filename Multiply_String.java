public class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";

        if (num1.equals("0") || (num2.equals("0"))) {
            return result;
        }

        int length = num2.length();
        String base = "";
        for (int i = length-1; i >= 0; i--) {
            char digit = num2.charAt(i);
            int numDigit = digit - '0';
            String res = multiplyByDigit(num1, numDigit) + base;
            result = add(res, result);
            base = base + '0';
        }
        return result;
    }

    private String multiplyByDigit(String num, int digit) {
        if (digit == 0) {
            return "0";
        }

        String result = "";
        int length = num.length();
        int carry = 0;
        for (int i = length-1; i >= 0; i--) {
            int number = num.charAt(i) - '0';
            int res = number * digit + carry;
            carry = res / 10;
            res = res % 10;
            result = res + result;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }

    private String add(String num1, String num2) {
        int carry = 0;
        int pos1 = num1.length() - 1;
        int pos2 = num2.length() - 1;
        String result = "";
        while ((pos1 >= 0) && (pos2 >= 0)) {
            int digit1 = num1.charAt(pos1) - '0';
            int digit2 = num2.charAt(pos2) - '0';
            int resDigit = digit1 + digit2 + carry;
            carry = resDigit / 10;
            resDigit = resDigit % 10;
            result = resDigit + result;
            pos1--;
            pos2--;
        }

        while (pos1 >= 0) {
            int digit1 = num1.charAt(pos1) - '0';
            int resDigit = digit1 + carry;
            carry = resDigit / 10;
            resDigit = resDigit % 10;
            result = resDigit + result;
            pos1--;
        }

        while (pos2 >= 0) {
            int digit2 = num2.charAt(pos2) - '0';
            int resDigit = digit2 + carry;
            carry = resDigit / 10;
            resDigit = resDigit % 10;
            result = resDigit + result;
            pos2--;
        }

        if (carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
