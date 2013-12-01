public class Solution {
    public String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();

        String binary = "";
        if ((length1 == 0) && (length2 == 0)) {
            return binary;
        } else if (length1 == 0) {
            return b;
        } else if (length2 == 0) {
            return a;
        }

        int carry = 0;
        while ((length1 > 0) && (length2 > 0)) {
            length1--;
            length2--;
            char ch1 = a.charAt(length1);
            char ch2 = b.charAt(length2);
            int num1 = (ch1 == '0') ? 0 : 1;
            int num2 = (ch2 == '0') ? 0 : 1;

            int num = num1 + num2 + carry;
            if (num >= 2) {
                num = num - 2;
                carry = 1;
            } else {
                carry = 0;
            }
            char ch = (num == 0) ? '0' : '1';
            binary = ch + binary;
        }

        while (length1 > 0) {
            length1--;
            char ch1 = a.charAt(length1);
            int num1 = (ch1 == '0') ? 0 : 1;

            int num = num1 + carry;
            if (num >= 2) {
                num = num - 2;
                carry = 1;
            } else {
                carry = 0;
            }
            char ch = (num == 0) ? '0' : '1';
            binary = ch + binary;
        }

         while (length2 > 0) {
            length2--;
            char ch2 = b.charAt(length2);
            int num2 = (ch2 == '0') ? 0 : 1;

            int num = num2 + carry;
            if (num >= 2) {
                num = num - 2;
                carry = 1;
            } else {
                carry = 0;
            }
            char ch = (num == 0) ? '0' : '1';
            binary = ch + binary;
        }

        if (carry == 1) {
            binary = '1' + binary;
        }
        return binary;
    }
}
